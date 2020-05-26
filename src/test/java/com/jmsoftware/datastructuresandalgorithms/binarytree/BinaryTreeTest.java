package com.jmsoftware.datastructuresandalgorithms.binarytree;

import com.jmsoftware.datastructuresandalgorithms.binarytree.entity.BinaryTreeNode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * <h1>BinaryTreeTest</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 4:35 PM
 **/
@Slf4j
@SpringBootTest
public class BinaryTreeTest {
    /**
     * <p>Tree:</p>
     * <pre>
     * <code>          Node 1
     *          /      \
     *      Node 2   Node 3
     *       /        /
     *    Node 4   Node 5</code>
     * </pre>
     * <p>&nbsp;</p>
     */
    @Test
    public void traverseBinaryTreeTest() {
        val node1 = new BinaryTreeNode<>("Node 1");
        val node2 = new BinaryTreeNode<>("Node 2");
        val node3 = new BinaryTreeNode<>("Node 3");
        val node4 = new BinaryTreeNode<>("Node 4");
        val node5 = new BinaryTreeNode<>("Node 5");
        node1.setLeftChildNode(node2);
        node1.setRightChildNode(node3);
        node2.setLeftChildNode(node4);
        node3.setLeftChildNode(node5);

        val traversalByPreorder = new LinkedList<String>();
        BinaryTreeNode.recursivelyTraverseByPreorder(node1, traversalByPreorder);
        log.info("Traverse binary tree by preorder: {}", traversalByPreorder);

        val traversalByInorder = new LinkedList<String>();
        BinaryTreeNode.recursivelyTraverseByInorder(node1, traversalByInorder);
        log.info("Traverse binary tree by inorder: {}", traversalByInorder);

        val traversalByPostorder = new LinkedList<String>();
        BinaryTreeNode.recursivelyTraverseByPostorder(node1, traversalByPostorder);
        log.info("Traverse binary tree by postorder: {}", traversalByPostorder);

        val treeDiagramByTraversingInPreOrder = node1.getTreeDiagramByTraversingInPreorder();
        log.info("Binary tree diagram: {}{}", System.lineSeparator(), treeDiagramByTraversingInPreOrder);
    }
}
