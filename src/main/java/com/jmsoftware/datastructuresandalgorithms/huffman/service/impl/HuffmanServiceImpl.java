package com.jmsoftware.datastructuresandalgorithms.huffman.service.impl;

import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanTreeDiagramPayload;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanTreeDiagramResponse;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.HuffmanTree;
import com.jmsoftware.datastructuresandalgorithms.huffman.service.HuffmanService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <h1>HuffmanServiceImpl</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 9:52 AM
 **/
@Slf4j
@Service
public class HuffmanServiceImpl implements HuffmanService {
    @Override
    public GetHuffmanTreeDiagramResponse getHuffmanTreeDiagram(GetHuffmanTreeDiagramPayload payload) {
        val response = new GetHuffmanTreeDiagramResponse();
        val frequencyMap = HuffmanTree.calculateFrequency(payload.getContent());
        log.info("Frequency map: {}", frequencyMap);
        val rootNode = HuffmanTree.generateHuffmanTree(frequencyMap);
        log.info("Root: {}", rootNode);
        val huffmanCodeMap = new HashMap<Character, String>(32);
        HuffmanTree.recursiveTraverseInPreOrderHuffmanTree(rootNode, "", huffmanCodeMap);
        log.info("Huffman code map: {}", huffmanCodeMap);
        val treeDiagramByTraversingInPreOrder = rootNode.getTreeDiagramByTraversingInPreOrder();
        log.info("Huffman tree diagram: {}{}", System.lineSeparator(), treeDiagramByTraversingInPreOrder);
        response.setDiagram(treeDiagramByTraversingInPreOrder);
        response.setHuffmanCodeMap(huffmanCodeMap);
        return response;
    }
}
