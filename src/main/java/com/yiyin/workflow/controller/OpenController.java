package com.yiyin.workflow.controller;

import com.yiyin.workflow.bean.pojo.common.JsonResult;
import com.yiyin.workflow.bean.pojo.dto.LoginDTO;
import com.yiyin.workflow.constant.ApiPrefixConstant;
import com.yiyin.workflow.constant.BizCode;
import com.yiyin.workflow.entity.Employees;
import com.yiyin.workflow.service.EmployeesService;
import com.yiyin.workflow.utils.IPLocationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.net.InetAddress;
import java.time.LocalDateTime;

@Slf4j
@RestController
@Api( tags = "用户登录接口处理")
@RequestMapping(value = ApiPrefixConstant.V1 + "/open")
public class OpenController {

    private final EmployeesService employeesService;

    public OpenController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    /**
     * post表单提交，登录
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public JsonResult login(@RequestBody @Valid LoginDTO dto,HttpServletRequest request) {
        @NotEmpty(message = "用户名不能为空") String username = dto.getUsername();
        @NotEmpty(message = "密码不能为空") String password = dto.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject user = SecurityUtils.getSubject();
        try {
            //shiro帮我们匹配密码Model什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
            user.login(token);
            Employees employees = (Employees)user.getPrincipals().getPrimaryPrincipal();
            String ipAddr = getIpAddr(request);
            String address = IPLocationUtils.cityName(ipAddr);
            employees.setLastLoginTime(LocalDateTime.now());
            employees.setLoginAddress(address);
            employees.setLoginIp(ipAddr);
            employeesService.updateById(employees);
            return JsonResult.createSuccess();
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            log.error("message 账号不存在！");
        } catch (DisabledAccountException e) {
            log.error("message 账号未启用！");
        } catch (IncorrectCredentialsException e) {
            log.error("message 密码错误！");
        } catch (Throwable e) {
            log.error("message 未知错误！");
        }
        return JsonResult.createFalied(BizCode.PWD_ERROR);
    }

    /**
     * 退出
     *
     * @return
     */
    @ApiOperation(value = "注销")
    @PostMapping("/logout")
    public JsonResult logout() {
        SecurityUtils.getSubject().logout();
        return JsonResult.createSuccess();
    }

    /**
     * 注册
     *
     * @return
     */
    @ApiOperation(value = "注册（暂时没用，手动添加用户）")
    public JsonResult registered() {
        return JsonResult.createSuccess();
    }

    /**
     * 获取客户端IP地址
     *
     * @param request
     * @return
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

}
