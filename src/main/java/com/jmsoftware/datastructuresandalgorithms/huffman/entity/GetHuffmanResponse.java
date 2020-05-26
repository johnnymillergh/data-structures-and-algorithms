package com.jmsoftware.datastructuresandalgorithms.huffman.entity;

import lombok.Data;

import java.util.Map;

/**
 * <h1>GetHuffmanResponse</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 9:49 AM
 **/
@Data
public class GetHuffmanResponse {
    private String encodedContent;
    private Map<Character, String> huffmanCodeMap;
    private String huffmanTreeAsciiDiagram;
}
