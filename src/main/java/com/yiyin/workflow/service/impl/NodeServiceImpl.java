package com.yiyin.workflow.service.impl;

import com.yiyin.workflow.entity.Node;
import com.yiyin.workflow.dao.NodeMapper;
import com.yiyin.workflow.service.NodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目节点 服务实现类
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {

}
