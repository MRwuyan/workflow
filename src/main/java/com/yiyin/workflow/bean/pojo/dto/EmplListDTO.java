package com.yiyin.workflow.bean.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmplListDTO {

    @ApiModelProperty("邮箱")
    private String name;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("部门ID")
    private Long departmentId;

    @ApiModelProperty("状态")
    private Integer status;


}
