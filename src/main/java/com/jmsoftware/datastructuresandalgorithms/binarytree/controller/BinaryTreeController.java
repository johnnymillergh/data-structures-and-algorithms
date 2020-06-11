package com.jmsoftware.datastructuresandalgorithms.binarytree.controller;

import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.CreateBinaryTreePayload;
import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.CreateBinaryTreeResponse;
import com.jmsoftware.datastructuresandalgorithms.binarytree.service.BinaryTreeService;
import com.jmsoftware.datastructuresandalgorithms.common.bean.ResponseBodyBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <h1>BinaryTreeController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 6/9/20 4:42 PM
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/binary-tree")
@Api(tags = {"Binary Tree Controller"})
public class BinaryTreeController {
    private final BinaryTreeService binaryTreeService;

    @PostMapping("/create-binary-tree")
    @ApiOperation(value = "/create-binary-tree", notes = "Create binary tree")
    public ResponseBodyBean<CreateBinaryTreeResponse> createBinaryTree(
            @Valid @RequestBody CreateBinaryTreePayload payload) {
        CreateBinaryTreeResponse response = binaryTreeService.createBinaryTree(payload);
        return ResponseBodyBean.ofSuccess(response);
    }
}
