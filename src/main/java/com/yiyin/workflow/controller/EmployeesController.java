package com.yiyin.workflow.controller;


import com.yiyin.workflow.bean.pojo.common.JsonResult;
import com.yiyin.workflow.bean.pojo.dto.EmplListDTO;
import com.yiyin.workflow.bean.pojo.dto.EmplSaveDTO;
import com.yiyin.workflow.bean.pojo.dto.EmplUpdateDTO;
import com.yiyin.workflow.entity.Employees;
import com.yiyin.workflow.service.EmployeesService;
import com.yiyin.workflow.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Api( tags = "员工数据处理接口")
@RestController
@RequestMapping("/employees")
public class EmployeesController {
    final
    EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }


    @ApiOperation(value = "员工创建")
    @PostMapping("/save")
    public JsonResult save(@RequestBody @Valid EmplSaveDTO dto){
        Employees employees = new Employees();
        BeanUtils.copyProperties(employees,dto);
        employees.setCreateTime(LocalDateTime.now());
        employees.setLastLoginTime(LocalDateTime.now());
        employees.setLoginAddress("~~");
        employees.setLoginIp("0.0.0.0");
        String salt = Md5Utils.salt();
        String password = Md5Utils.md5(salt + dto.getPassword());
        employees.setSalt(salt);
        employees.setPassword(password);
        employeesService.save(employees);
        return JsonResult.createSuccess();
    }
    @ApiOperation(value = "员工删除")
    @PostMapping("/remove")
    public JsonResult remove(@RequestParam("id") Long id){
        employeesService.removeById(id);
        return JsonResult.createSuccess();
    }
    @ApiOperation(value = "员工修改")
    @PostMapping("/update")
    public JsonResult update(@RequestBody @Valid EmplUpdateDTO dto){
        Employees employees = employeesService.getById(dto.getId());
        BeanUtils.copyProperties(dto,employees);
        if (!StringUtils.isEmpty(dto.getPassword())) {
            String password = Md5Utils.md5(employees.getSalt() + dto.getPassword());
            employees.setPassword(password);
        }
        employeesService.updateById(employees);
        return JsonResult.createSuccess();
    }

    @ApiOperation(value = "员工查询")
    @PostMapping("/list")
    public JsonResult list(@RequestBody @Valid EmplListDTO dto){
        return employeesService.queryEmployess(dto);
    }

}

