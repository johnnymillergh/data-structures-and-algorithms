package com.jmsoftware.datastructuresandalgorithms.binarytree.entity;

import cn.hutool.core.util.ObjectUtil;
import com.jmsoftware.datastructuresandalgorithms.common.tree.BaseBinaryTreeNode;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.annotation.Nonnull;
import java.util.LinkedList;

/**
 * <h1>BinaryTreeNode</h1>
 * <p>
 * Change description here.
 *
 * @author Johnny Miller (鍾俊), email: johnnysviva@outlook.com
 * @date 5/26/20 3:57 PM
 **/
@Value
@EqualsAndHashCode(callSuper = true)
public class BinaryTreeNode<DataType> extends BaseBinaryTreeNode<BinaryTreeNode<DataType>> {
    DataType data;

    @Override
    public String outputNodeInformationFormat() {
        return data.toString();
    }

    /**
     * <p>Recursively traverse by preorder. Algorithm Preorder (tree):</p>
     * <ol>
     * <li>Visit the root;</li>
     * <li>Traverse the left subtree, i.e., call Preorder (left-subtree);</li>
     * <li>Traverse the right subtree, i.e., call Preorder (right-subtree).</li>
     * </ol>
     *
     * @param <DataType> the type parameter
     * @param rootNode   the root node
     * @param traversal  the traversal
     */
    public static <DataType> void recursivelyTraverseByPreorder(@Nonnull BinaryTreeNode<DataType> rootNode,
                                                                @Nonnull LinkedList<DataType> traversal) {
        traversal.add(rootNode.data);
        if (ObjectUtil.isNotNull(rootNode.getLeftChildNode())) {
            recursivelyTraverseByPreorder((BinaryTreeNode<DataType>) rootNode.getLeftChildNode(), traversal);
        }
        if (ObjectUtil.isNotNull(rootNode.getRightChildNode())) {
            recursivelyTraverseByPreorder((BinaryTreeNode<DataType>) rootNode.getRightChildNode(), traversal);
        }
    }

    /**
     * <p>Recursively traverse by inorder. Algorithm Inorder (tree):</p>
     * <ol>
     * <li>Traverse the left subtree, i.e., call Inorder (left-subtree);</li>
     * <li>Visit the root;</li>
     * <li>Traverse the right subtree, i.e., call Inorder (right-subtree).</li>
     * </ol>
     *
     * @param <DataType> the type parameter
     * @param rootNode   the root node
     * @param traversal  the traversal
     */
    public static <DataType> void recursivelyTraverseByInorder(@Nonnull BinaryTreeNode<DataType> rootNode,
                                                               @Nonnull LinkedList<DataType> traversal) {
        if (ObjectUtil.isNotNull(rootNode.getLeftChildNode())) {
            recursivelyTraverseByPreorder((BinaryTreeNode<DataType>) rootNode.getLeftChildNode(), traversal);
        }
        traversal.add(rootNode.data);
        if (ObjectUtil.isNotNull(rootNode.getRightChildNode())) {
            recursivelyTraverseByPreorder((BinaryTreeNode<DataType>) rootNode.getRightChildNode(), traversal);
        }
    }

    /**
     * <p>Recursively traverse by postorder. Algorithm Postorder (tree)</p>
     * <ol>
     * <li>Traverse the left subtree, i.e., call Postorder (left-subtree);</li>
     * <li>Traverse the right subtree, i.e., call Postorder (right-subtree);</li>
     * <li>Visit the root.</li>
     * </ol>
     *
     * @param <DataType> the type parameter
     * @param rootNode   the root node
     * @param traversal  the traversal
     */
    @SuppressWarnings("SpellCheckingInspection")
    public static <DataType> void recursivelyTraverseByPostorder(@Nonnull BinaryTreeNode<DataType> rootNode,
                                                                 @Nonnull LinkedList<DataType> traversal) {
        if (ObjectUtil.isNotNull(rootNode.getLeftChildNode())) {
            recursivelyTraverseByPreorder((BinaryTreeNode<DataType>) rootNode.getLeftChildNode(), traversal);
        }
        if (ObjectUtil.isNotNull(rootNode.getRightChildNode())) {
            recursivelyTraverseByPreorder((BinaryTreeNode<DataType>) rootNode.getRightChildNode(), traversal);
        }
        traversal.add(rootNode.data);
    }
}
