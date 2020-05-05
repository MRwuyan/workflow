package com.yiyin.workflow.utils;

import com.yiyin.workflow.entity.Employees;
import lombok.experimental.UtilityClass;
import org.apache.shiro.SecurityUtils;

/**
 * 用户工具类
 */
@UtilityClass
public class EmployeesUtils {
    public Employees getCurr(){
        return (Employees) SecurityUtils.getSubject().getPrincipal();
    }
}
