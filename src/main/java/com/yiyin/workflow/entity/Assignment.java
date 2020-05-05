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
 * 项目任务
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Assignment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务类型ID

     */
    private Long assignmentTypeId;

    private String content;

    /**
     * 预计时间
     */
    private LocalDateTime estimatedStartTime;

    /**
     * 预计结束时间
     */
    private LocalDateTime estimatedEndTime;

    /**
     * 预计工时
     */
    private Integer workingHours;

    /**
     * 协助人ID
     */
    private Long assistId;

    /**
     * 负责人ID

     */
    private Long headId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人ID
     */
    private Long createById;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
