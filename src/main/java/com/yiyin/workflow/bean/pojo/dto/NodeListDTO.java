package com.yiyin.workflow.bean.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NodeListDTO {
    @NotNull
    private Integer pageSize;

    @NotNull
    private Integer pageIndex;
}
