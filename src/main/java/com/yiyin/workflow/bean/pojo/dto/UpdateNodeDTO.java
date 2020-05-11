package com.yiyin.workflow.bean.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateNodeDTO {
    @NotNull
    @ApiModelProperty("节点id")
    private Long id;
    /**
     * 节点名称
     */
    @NotNull
    @ApiModelProperty("节点名称")
    private String name;

    /**
     * 节点类型id
     */
    @NotNull
    @ApiModelProperty("节点类型id")
    private Long nodeTypeId;

    /**
     * 节点相关资质
     */
    @NotEmpty
    @ApiModelProperty("节点相关资质")
    private String qualification;
}
