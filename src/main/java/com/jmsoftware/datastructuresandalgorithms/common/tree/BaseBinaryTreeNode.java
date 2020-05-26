package com.jmsoftware.datastructuresandalgorithms.common.tree;

import lombok.Data;
import lombok.val;

/**
 * <h1>BaseBinaryTreeNode</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/25/20 10:49 PM
 **/
@Data
public abstract class BaseBinaryTreeNode<NodeType> {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    BaseBinaryTreeNode<NodeType> leftChildNode;
    BaseBinaryTreeNode<NodeType> rightChildNode;

    /**
     * Is leaf boolean.
     *
     * @return the boolean
     */
    public boolean isLeaf() {
        return leftChildNode == null && rightChildNode == null;
    }

    /**
     * Output node information format string.
     *
     * @return the string
     */
    public abstract String outputNodeInformationFormat();

    /**
     * Gets tree diagram by traversing in pre order.
     *
     * @return the tree diagram by traversing in pre order
     */
    public final String getTreeDiagramByTraversingInPreOrder() {
        val content = new StringBuilder();
        content.append(this.outputNodeInformationFormat());
        val pointerRight = "└──";
        val pointerLeft = (this.getRightChildNode() != null) ? "├──" : "└──";
        recursiveTraverseNodes(content, "", pointerLeft, this.getLeftChildNode(),
                               this.getRightChildNode() != null);
        recursiveTraverseNodes(content, "", pointerRight, this.getRightChildNode(), false);
        return content.toString();
    }

    /**
     * Recursive traverse nodes.
     *
     * @param content         the content
     * @param padding         the padding
     * @param pointer         the pointer
     * @param node            the node
     * @param hasRightSibling the has right sibling
     */
    private void recursiveTraverseNodes(StringBuilder content, String padding, String pointer,
                                        BaseBinaryTreeNode<NodeType> node,
                                        boolean hasRightSibling) {
        if (node != null) {
            content.append(LINE_SEPARATOR);
            content.append(padding);
            content.append(pointer);
            content.append(node.outputNodeInformationFormat());

            val paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            val paddingForBoth = paddingBuilder.toString();
            val pointerRight = "└──";
            val pointerLeft = (node.getRightChildNode() != null) ? "├──" : "└──";

            recursiveTraverseNodes(content, paddingForBoth, pointerLeft, node.getLeftChildNode(),
                                   node.getRightChildNode() != null);
            recursiveTraverseNodes(content, paddingForBoth, pointerRight, node.getRightChildNode(), false);
        }
    }
}
