package com.yiyin.workflow.controller;


import com.yiyin.workflow.bean.pojo.common.JsonResult;
import com.yiyin.workflow.bean.pojo.dto.EmplSaveDTO;
import com.yiyin.workflow.bean.pojo.dto.SaveNodeDTO;
import com.yiyin.workflow.bean.pojo.dto.UpdateNodeDTO;
import com.yiyin.workflow.entity.Employees;
import com.yiyin.workflow.entity.Node;
import com.yiyin.workflow.service.NodeService;
import com.yiyin.workflow.utils.EmployeesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目节点 前端控制器
 * </p>
 *
 * @author chenxiaopeng
 * @since 2020-05-02
 */
@Api( tags = "节点数据处理接口")
@RestController
@RequestMapping("/node")
public class NodeController {
    final
    NodeService service;
    @Autowired
    public NodeController(NodeService nodeService) {
        this.service = nodeService;
    }
    @ApiOperation(value = "节点创建")
    @PostMapping("/save")
    public JsonResult save(@RequestBody @Valid SaveNodeDTO dto){
        Node node = new Node();
        Employees curr = EmployeesUtils.getCurr();
        BeanUtils.copyProperties(dto,node);
        node.setCreateBy(curr.getId());
        node.setCreateTime(LocalDateTime.now());
        service.save(node);
       return JsonResult.createSuccess();
    }
    @ApiOperation(value = "节点修改")
    @PostMapping("/update")
    public JsonResult update(@RequestBody @Valid UpdateNodeDTO dto){
        Employees curr = EmployeesUtils.getCurr();
        @NotNull Long id = dto.getId();
        Node node = service.getById(id);
        BeanUtils.copyProperties(dto,node);
        service.updateById(node);
        return JsonResult.createSuccess();
    }
}

