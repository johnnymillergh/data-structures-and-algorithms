package com.jmsoftware.datastructuresandalgorithms.binarytree.service.impl;

import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.BinaryTree;
import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.CreateBinaryTreePayload;
import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.CreateBinaryTreeResponse;
import com.jmsoftware.datastructuresandalgorithms.binarytree.service.BinaryTreeService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <h1>BinaryTreeServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 4:02 PM
 **/
@Slf4j
@Service
public class BinaryTreeServiceImpl implements BinaryTreeService {
    @Override
    public CreateBinaryTreeResponse createBinaryTree(CreateBinaryTreePayload payload) {
        final var preorderDataList1 = new ArrayList<>(payload.getPreorderList());
        final var inorderDataList1 = new ArrayList<>(payload.getInorderList());
        val rootNode = BinaryTree.constructByPreorderAndInorder(preorderDataList1, inorderDataList1);
        log.info("{}", rootNode.getTreeDiagramByTraversingInPreorder());
        CreateBinaryTreeResponse response = new CreateBinaryTreeResponse();
        response.setRootNode(rootNode);
        return response;
    }
}
