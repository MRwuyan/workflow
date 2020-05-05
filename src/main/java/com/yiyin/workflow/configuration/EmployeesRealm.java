package com.yiyin.workflow.configuration;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.yiyin.workflow.entity.Employees;
import com.yiyin.workflow.entity.SysEmpyRole;
import com.yiyin.workflow.entity.SysPermission;
import com.yiyin.workflow.service.EmployeesService;
import com.yiyin.workflow.service.SysEmpyRoleService;
import com.yiyin.workflow.service.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EmployeesRealm extends AuthorizingRealm {

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private SysEmpyRoleService sysEmpyRoleService;

    @Autowired
    private EmployeesService employeesService;
    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Employees sysUser = (Employees) principals.getPrimaryPrincipal();

        List<SysEmpyRole> list = sysEmpyRoleService.list(new LambdaQueryWrapper<SysEmpyRole>().eq(SysEmpyRole::getEmpyId, sysUser.getId()));
        List<Long> roleIds = list.stream().map(SysEmpyRole::getRoleId).collect(Collectors.toList());
        List<SysPermission> permissionList = sysPermissionService.list(new LambdaQueryWrapper<SysPermission>().in(SysPermission::getId, roleIds));

        List<String> permissions = permissionList.stream().map(SysPermission::getPermission).collect(Collectors.toList());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        log.info("doGetAuthorizationInfo");
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Employees sysUser = employeesService.getOne(new LambdaQueryWrapper<Employees>().eq(Employees::getName,token.getUsername()));
        if (sysUser == null) {
            return null;
        }
        log.info("doGetAuthenticationInfo");
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().toCharArray(), ByteSource.Util.bytes(sysUser.getId().toString()), getName());
        return simpleAuthenticationInfo;
    }
}
