package com.yiyin.workflow.bean.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeesVO {

    @ApiModelProperty("用户名")
    private String name;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 头像url
     */
    @ApiModelProperty("头像url")
    private String icon;

    /**
     * 部门id

     */
    @ApiModelProperty("部门名称")
    private Long departmentName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    private LocalDateTime lastLoginTime;

    /**
     * 登录地点
     */
    @ApiModelProperty("登录地点")
    private String loginAddress;

    /**
     * 登录ip
     */
    @ApiModelProperty("登录ip")
    private String loginIp;

    /**
     * 状态:1.在职.2离职
     */
    @ApiModelProperty("状态:1.在职.2离职")
    private Integer status;
    /**
     *  性别:1.男,2.女
     */
    @ApiModelProperty("性别:1.男,2.女")
    private Integer sex;

    /**
     * 出生年月日
     */
    @ApiModelProperty("出生年月日")
    private LocalDateTime birthday;
}
