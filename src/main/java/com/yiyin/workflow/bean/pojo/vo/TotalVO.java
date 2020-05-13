package com.yiyin.workflow.bean.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * list 返回对象
 * @param <T>
 */
@Data
public class TotalVO<T> {
    @ApiModelProperty("数组对象")
    private List<T> data;
    @ApiModelProperty("总数量")
    private Integer count;
}
