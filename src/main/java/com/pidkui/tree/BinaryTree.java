package com.pidkui.tree;

/*
Binary Tree:
    A binary tree is a hierarchical data structure in which each node has at most two children,
    commonly referred to as the left and right child.

Pre-Order Traversal:
    1. Visit (Print) Root Node
    2. Traverse Left Subtree
    3. Traverse Right Subtree
    * Traversal Order: Root → Left → Right

In-Order Traversal:
    1. Traverse Left Subtree
    2. Visit (Print) Root Node
    3. Traverse Right Subtree
    * Traversal Order: Left → Root → Right

Post-Order Traversal:
    1. Traverse Left Subtree
    2. Traverse Right Subtree
    3. Visit (Print) Root Node
    * Traversal Order: Left → Right → Root
 */

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
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
        if (root == null) { // base condition
            return;
        }
        System.out.print(root.data + " ");
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
    }

    private void recursiveInOrderTraversal(TreeNode root) {
        if (root == null) { // base condition
            return;
        }
        recursiveInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        recursiveInOrderTraversal(root.right);
    }

    private void recursivePostOrderTraversal(TreeNode root) {
        if (root == null) { // base condition
            return;
        }
        recursivePostOrderTraversal(root.left);
        recursivePostOrderTraversal(root.right);
        System.out.print(root.data + " ");
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

    private void iterativeInOrderTraversal() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    private void iterativePostOrderTraversal() {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    private void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }

        return result;
    }

    private int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int result = root.data;
        int left = findMin(root.left);
        int right = findMin(root.right);

        if (left < result) {
            result = left;
        }
        if (right < result) {
            result = right;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        System.out.println("PreOrder Traversal (Recursive):");
        binaryTree.recursivePreOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("InOrder Traversal (Recursive):");
        binaryTree.recursiveInOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("PostOrder Traversal (Recursive):");
        binaryTree.recursivePostOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println();

        System.out.println("PreOrder Traversal (Iterative):");
        binaryTree.iterativePreOrderTraversal();
        System.out.println();

        System.out.println("InOrder Traversal (Iterative):");
        binaryTree.iterativeInOrderTraversal();
        System.out.println();

        System.out.println("PostOrder Traversal (Iterative):");
        binaryTree.iterativePostOrderTraversal();
        System.out.println();

        System.out.println("Level Order Traversal:");
        binaryTree.levelOrderTraversal();
        System.out.println();

        System.out.println("Max Value in Binary Tree:");
        System.out.println(binaryTree.findMax(binaryTree.root));

        System.out.println("Min Value in Binary Tree:");
        System.out.println(binaryTree.findMin(binaryTree.root));
    }
}
