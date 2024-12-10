package com.pidkui.tree.questionsBST;

public class FlattenBinaryTreeToLinkedList {
    TreeNode root;

    public FlattenBinaryTreeToLinkedList() {
        root = null;
    }

    private void createBinaryTree() {
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(6);
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(3);
        TreeNode sixth = new TreeNode(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.right = sixth;
    }

    private void flattenTree(TreeNode root) {
        if (root == null) {
            return;
        }

        flattenTree(root.left);
        flattenTree(root.right);

        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = tempNode;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList binaryTree = new FlattenBinaryTreeToLinkedList();
        binaryTree.createBinaryTree();
        binaryTree.flattenTree(binaryTree.root);

        TreeNode current = binaryTree.root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }
}
