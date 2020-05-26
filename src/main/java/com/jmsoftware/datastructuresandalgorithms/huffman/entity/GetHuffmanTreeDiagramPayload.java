package com.jmsoftware.datastructuresandalgorithms.huffman.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <h1>GetHuffmanTreeDiagramPayload</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 9:48 AM
 **/
@Data
public class GetHuffmanTreeDiagramPayload {
    @NotEmpty
    private String content;
}
