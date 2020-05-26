package com.jmsoftware.datastructuresandalgorithms.huffman.controller;

import com.jmsoftware.datastructuresandalgorithms.common.bean.ResponseBodyBean;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanTreeDiagramPayload;
import com.jmsoftware.datastructuresandalgorithms.huffman.entity.GetHuffmanTreeDiagramResponse;
import com.jmsoftware.datastructuresandalgorithms.huffman.service.HuffmanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <h1>HuffmanController</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 9:45 AM
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/huffman")
@Api(tags = {"Huffman Controller"})
public class HuffmanController {
    private final HuffmanService huffmanService;

    @GetMapping("/get-huffman-tree-diagram")
    @ApiOperation(value = "/get-huffman-tree-diagram", notes = "Get huffman tree diagram")
    public ResponseBodyBean<GetHuffmanTreeDiagramResponse> getHuffmanTreeDiagram(
            @Valid GetHuffmanTreeDiagramPayload payload) {
        return ResponseBodyBean.ofSuccess(huffmanService.getHuffmanTreeDiagram(payload));
    }
}
