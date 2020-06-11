package com.jmsoftware.datastructuresandalgorithms.binarytree.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <h1>CreateBinaryTreePayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 6/9/20 4:45 PM
 **/
@Data
public class CreateBinaryTreePayload {
    @NotEmpty
    private List<String> preorderList;
    @NotEmpty
    private List<String> inorderList;
}
