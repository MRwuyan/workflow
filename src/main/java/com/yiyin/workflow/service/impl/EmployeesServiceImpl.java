package com.yiyin.workflow.service.impl;

import com.yiyin.workflow.entity.Employees;
import com.yiyin.workflow.dao.EmployeesMapper;
import com.yiyin.workflow.service.EmployeesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements EmployeesService {

}
