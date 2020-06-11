package com.jmsoftware.datastructuresandalgorithms.binarytree.entity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h1>BinaryTree</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/27/20 9:17 AM
 **/
@Slf4j
public class BinaryTree {
    static int preorderIndex = 0;

    /**
     * Construct by preorder binary tree node.
     *
     * @param <DataType>       the type parameter
     * @param preorderDataList the preorder data list
     * @param inorderDataList  the inorder data list
     * @return the binary tree node
     */
    public static <DataType> BinaryTreeNode<DataType> constructByPreorderAndInorder(
            @NonNull List<DataType> preorderDataList, @NonNull List<DataType> inorderDataList) {
        val stack = new Stack<BinaryTreeNode<DataType>>();
        val set = new HashSet<BinaryTreeNode<DataType>>();

        BinaryTreeNode<DataType> root = null;
        for (int preorderIndex = 0, inorderIndex = 0; preorderIndex < preorderDataList.size(); ) {
            BinaryTreeNode<DataType> node;
            do {
                node = new BinaryTreeNode<>(preorderDataList.get(preorderIndex));
                if (root == null) {
                    root = node;
                }
                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().setRightChildNode(node);
                    } else {
                        stack.peek().setLeftChildNode(node);
                    }
                }
                stack.push(node);
            } while (preorderDataList.get(preorderIndex++) != inorderDataList
                    .get(inorderIndex) && preorderIndex < preorderDataList.size());

            node = null;
            while (!stack.isEmpty() && inorderIndex < inorderDataList.size()
                   && stack.peek().getData() == inorderDataList.get(inorderIndex)) {
                node = stack.pop();
                inorderIndex++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }
        return root;
    }

    /**
     * Recursively construct binary tree node.
     *
     * @param <DataType>       the type parameter
     * @param preorderDataList the preorder data list
     * @param inorderDataList  the inorder data list
     * @return the binary tree node
     */
    public static <DataType> BinaryTreeNode<DataType> recursivelyConstruct(@NonNull List<DataType> preorderDataList,
                                                                           @NonNull List<DataType> inorderDataList) {
        if (preorderIndex != 0) {
            preorderIndex = 0;
        }
        return BinaryTree.recursivelyConstructByPreorderAndInorder(preorderDataList, inorderDataList, 0,
                                                                   preorderDataList.size() - 1);
    }

    /**
     * Recursively construct by preorder and inorder binary tree node.
     *
     * @param <DataType>        the type parameter
     * @param preorderDataList  the preorder data list
     * @param inorderDataList   the inorder data list
     * @param inorderStartIndex the inorder start index
     * @param inorderEndIndex   the inorder end index
     * @return the binary tree node
     * @see
     * <a href='https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/'>Construct Tree from given Inorder and Preorder traversals</a>
     */
    private static <DataType> BinaryTreeNode<DataType> recursivelyConstructByPreorderAndInorder(
            @NonNull List<DataType> preorderDataList,
            @NonNull List<DataType> inorderDataList,
            int inorderStartIndex,
            int inorderEndIndex) {
        if (inorderStartIndex > inorderEndIndex) {
            return null;
        }

        // Pick current node from Preorder traversal using preIndex and increment preIndex
        val rootNode = new BinaryTreeNode<>(preorderDataList.get(preorderIndex++));

        // If this node has no children then return
        if (inorderStartIndex == inorderEndIndex) {
            return rootNode;
        }

        // Else find the index of this node in Inorder traversal
        int searchIndex = search(inorderDataList, inorderStartIndex, inorderEndIndex, rootNode.getData());

        // Using index in Inorder traversal, construct left and right subtress
        rootNode.setLeftChildNode(
                recursivelyConstructByPreorderAndInorder(preorderDataList,
                                                         inorderDataList,
                                                         inorderStartIndex,
                                                         searchIndex - 1));
        rootNode.setRightChildNode(
                recursivelyConstructByPreorderAndInorder(preorderDataList,
                                                         inorderDataList,
                                                         searchIndex + 1,
                                                         inorderEndIndex));
        return rootNode;
    }

    /**
     * Search int.
     *
     * @param <DataType>        the type parameter
     * @param inorderDataList   the inorder data list
     * @param inorderStartIndex the inorder start index
     * @param inorderEndIndex   the inorder end index
     * @param data              the data
     * @return the int
     */
    private static <DataType> int search(@NonNull List<DataType> inorderDataList, int inorderStartIndex,
                                         int inorderEndIndex,
                                         DataType data) {
        int index;
        for (index = inorderStartIndex; index <= inorderEndIndex; index++) {
            if (inorderDataList.get(index).equals(data)) {
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        val preorderNodeDataArray = new String[]{"node1", "node2", "node4", "node5", "node3", "node6"};
        val inorderNodeDataArray = new String[]{"node4", "node2", "node5", "node1", "node3", "node6"};
        val preorderDataList = Arrays.asList(preorderNodeDataArray);
        val inorderDataList = Arrays.asList(inorderNodeDataArray);
        val node2 = BinaryTree.constructByPreorderAndInorder(preorderDataList, inorderDataList);
        System.out.println(node2.getTreeDiagramByTraversingInPreorder());
    }
}
