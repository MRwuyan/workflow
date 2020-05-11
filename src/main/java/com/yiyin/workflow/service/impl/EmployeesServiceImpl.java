package com.yiyin.workflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yiyin.workflow.bean.pojo.common.JsonResult;
import com.yiyin.workflow.bean.pojo.dto.EmplListDTO;
import com.yiyin.workflow.bean.pojo.dto.EmplUpdateDTO;
import com.yiyin.workflow.entity.Employees;
import com.yiyin.workflow.dao.EmployeesMapper;
import com.yiyin.workflow.service.EmployeesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

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

    @Override
    public JsonResult queryEmployess(EmplListDTO dto) {
        Long departmentId = dto.getDepartmentId();
        String name = dto.getName();
        Long roleId = dto.getRoleId();
        Integer status = dto.getStatus();
        LambdaQueryWrapper<Employees> wrapper = new LambdaQueryWrapper();
        if (roleId!=null) {

        }
        if (!StringUtils.isBlank(name)) {
            wrapper.like(Employees::getName, name);
        }
        if (departmentId!=null) {
            wrapper.eq(Employees::getDepartmentId, departmentId);
        }
        if (status!=null) {
            wrapper.eq(Employees::getStatus, status);
        }
        List<Employees> list = list(wrapper);


        return null;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
        System.out.println(replace);
        System.out.println(replace.length());
    }
}
