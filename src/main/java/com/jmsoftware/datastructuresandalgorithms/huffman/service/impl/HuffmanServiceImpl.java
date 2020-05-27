package com.jmsoftware.datastructuresandalgorithms.huffman.service.impl;

import com.jmsoftware.datastructuresandalgorithms.common.aspect.ValidateArgument;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanPayload;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanResponse;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.HuffmanTree;
import com.jmsoftware.datastructuresandalgorithms.huffman.service.HuffmanService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    @ValidateArgument
    public GetHuffmanResponse getHuffman(@Valid GetHuffmanPayload payload) {
        val response = new GetHuffmanResponse();
        val frequencyMap = HuffmanTree.calculateFrequency(payload.getContent());
        log.info("Frequency map: {}", frequencyMap);
        val rootNode = HuffmanTree.generateHuffmanTree(frequencyMap);
        log.info("Root: {}", rootNode);
        val huffmanCodeMap = new HashMap<Character, String>(32);
        HuffmanTree.recursivelyTraverseHuffmanTreeByPreorder(rootNode, "", huffmanCodeMap);
        log.info("Huffman code map: {}", huffmanCodeMap);
        response.setHuffmanCodeMap(huffmanCodeMap);
        response.setEncodedContent(this.encodeTextByHuffmanCode(huffmanCodeMap, payload.getContent()));
        val treeDiagramByTraversingInPreOrder = rootNode.getTreeDiagramByTraversingInPreorder();
        log.info("Huffman tree diagram: {}{}", System.lineSeparator(), treeDiagramByTraversingInPreOrder);
        response.setHuffmanTreeAsciiDiagram(treeDiagramByTraversingInPreOrder);
        return response;
    }

    /**
     * Encode text by huffman code string.
     *
     * @param huffmanCodeMap the huffman code map
     * @param content        the content
     * @return the string
     */
    private String encodeTextByHuffmanCode(@NonNull Map<Character, String> huffmanCodeMap, @NonNull String content) {
        StringBuilder encodedText = new StringBuilder();
        for (var index = 0; index < content.length(); index++) {
            val character = content.charAt(index);
            val huffmanCodeOfCharacter = huffmanCodeMap.get(character);
            encodedText.append(huffmanCodeOfCharacter);
        }
        return encodedText.toString();
    }
}
