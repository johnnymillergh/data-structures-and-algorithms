package com.jmsoftware.datastructuresandalgorithms.binarytree.service;

import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.CreateBinaryTreePayload;
import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.CreateBinaryTreeResponse;

/**
 * <h1>BinaryTreeService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5 /26/20 4:01 PM
 */
public interface BinaryTreeService {
    /**
     * Create binary tree create binary tree response.
     *
     * @param payload the payload
     * @return the create binary tree response
     */
    CreateBinaryTreeResponse createBinaryTree(CreateBinaryTreePayload payload);
}
