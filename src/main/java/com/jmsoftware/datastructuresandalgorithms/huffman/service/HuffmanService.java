package com.jmsoftware.datastructuresandalgorithms.huffman.service;

import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanPayload;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanResponse;

/**
 * <h1>HuffmanService</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 9:50 AM
 */
public interface HuffmanService {
    /**
     * Gets huffman tree diagram.
     *
     * @param payload the payload
     * @return the huffman tree diagram
     */
    GetHuffmanResponse getHuffman(GetHuffmanPayload payload);
}
