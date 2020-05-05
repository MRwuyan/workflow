package com.yiyin.workflow.bean.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisteredDTO {
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像url
     */
    private String icon;

    /**
     * 部门id

     */
    private Long departmentId;



}
