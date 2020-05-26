package com.jmsoftware.datastructuresandalgorithms.huffman;

import com.jmsoftware.datastructuresandalgorithms.common.constant.HttpStatus;
import com.jmsoftware.datastructuresandalgorithms.huffman.controller.HuffmanController;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanPayload;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <h1>HuffmanTreeTest</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 11:11 AM
 **/
@Slf4j
@SpringBootTest
public class HuffmanTreeTest {
    @Autowired
    private HuffmanController huffmanController;

    @Test
    public void getHuffmanTreeDiagramTest() {
        val payload = new GetHuffmanPayload();
        payload.setContent("GetHuffmanPayload");
        val response = huffmanController.getHuffmanPayload(payload);
        log.info("Succeed to get Huffman tree diagram: {}{}", System.lineSeparator(), response.getData().getHuffmanTreeAsciiDiagram());
        Assertions.assertEquals(HttpStatus.OK.getCode(), response.getStatus());
    }
}
