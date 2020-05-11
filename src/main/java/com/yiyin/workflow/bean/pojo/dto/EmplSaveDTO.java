package com.yiyin.workflow.bean.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class EmplSaveDTO {
    @NotEmpty
    @ApiModelProperty("名称")
    private String name;

    /**
     * 用户密码
     */
    @NotEmpty
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 手机号
     */
    @NotEmpty
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 邮箱
     */
    @NotEmpty
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 头像url
     */
    @NotEmpty
    @ApiModelProperty("头像url")
    private String icon;

    /**
     * 部门id
     */
    @NotNull
    @ApiModelProperty("部门id")
    private Long departmentId;

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
