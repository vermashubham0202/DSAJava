package com.pidkui.tree;

/*
Binary Tree:
    A binary tree is a hierarchical data structure in which each node has at most two children,
    commonly referred to as the left and right child.
 */

import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    private void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    private void recursivePreOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
    }

    private void iterativePreOrderTraversal() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        System.out.println("Recursive PreOrder Traversal:");
        binaryTree.recursivePreOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("Iterative PreOrder Traversal:");
        binaryTree.iterativePreOrderTraversal();
    }
}
