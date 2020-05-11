package com.yiyin.workflow.bean.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class SaveNodeDTO {

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
