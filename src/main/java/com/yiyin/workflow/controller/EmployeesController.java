package com.yiyin.workflow.controller;


import com.yiyin.workflow.bean.pojo.common.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @PostMapping("/save")
    public JsonResult save(){

        return null;
    }

}

