package com.jmsoftware.datastructuresandalgorithms.binarytree.entity;

import lombok.Data;

/**
 * <h1>CreateBinaryTreeResponse</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 6/9/20 4:47 PM
 **/
@Data
public class CreateBinaryTreeResponse {
    private BinaryTreeNode<String> rootNode;
    private Integer heightOfBinaryTree;
}
