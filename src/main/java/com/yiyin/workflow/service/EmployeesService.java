package com.yiyin.workflow.service;

import com.yiyin.workflow.bean.pojo.common.JsonResult;
import com.yiyin.workflow.bean.pojo.dto.EmplListDTO;
import com.yiyin.workflow.bean.pojo.dto.EmplUpdateDTO;
import com.yiyin.workflow.entity.Employees;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
public interface EmployeesService extends IService<Employees> {

    JsonResult queryEmployess(EmplListDTO dto);
}
