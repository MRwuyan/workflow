package com.yiyin.workflow.bean.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {

    @ApiModelProperty("名称")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
