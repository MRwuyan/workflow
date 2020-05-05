package com.yiyin.workflow.service.impl;

import com.yiyin.workflow.entity.Project;
import com.yiyin.workflow.dao.ProjectMapper;
import com.yiyin.workflow.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
