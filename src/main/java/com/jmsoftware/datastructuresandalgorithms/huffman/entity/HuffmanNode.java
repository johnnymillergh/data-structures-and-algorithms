package com.jmsoftware.datastructuresandalgorithms.huffman.entity;

import com.jmsoftware.datastructuresandalgorithms.common.tree.BaseBinaryTreeNode;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Comparator;

/**
 * <h1>HuffmanNode</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/24/20 10:50 PM
 **/
@Value
@EqualsAndHashCode(callSuper = true)
public class HuffmanNode extends BaseBinaryTreeNode<HuffmanNode> implements Comparator<HuffmanNode> {
    Integer weight;
    Character character;

    @Override
    public boolean isLeaf() {
        return this.getLeftChildNode() == null && this.getRightChildNode() == null && Character.isLetter(character);
    }

    @Override
    public String outputNodeInformationFormat() {
        if (this.isLeaf()) {
            return String.format("%d:%s", this.weight, this.character);
        }
        return String.format("%d", this.weight);
    }

    @Override
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.weight - node2.weight;
    }
}
