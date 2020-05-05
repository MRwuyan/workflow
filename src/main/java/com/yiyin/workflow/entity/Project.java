package com.yiyin.workflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目标签
     */
    private Integer labelId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 负责人
     */
    private Long employeesId;

    /**
     * 项目启动时间
     */
    private LocalDateTime startTime;

    /**
     * 最后更新人
     */
    private Long lastUpdateId;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 项目概要
     */
    private String synopsis;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
