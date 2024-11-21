package com.pidkui.tree.questionsBST;

import com.pidkui.tree.BinaryTree;

public class ValidateBST {
    TreeNode root;

    public ValidateBST() {
        root = null;
    }

    // for testing purpose only
    private void createValidBinaryTree() {
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(6);
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(3);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    // for testing purpose only
    private void createInvalidBinaryTree() {
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(6);
        TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    private boolean validate(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // validation algorithm
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        boolean left = isValidBST(root.left, min, root.data);
        if (left) {
            boolean right = isValidBST(root.right, root.data, max);
            return right;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidateBST tree1 = new ValidateBST();
        tree1.createInvalidBinaryTree();
        System.out.println("Is Tree1 valid BST?: " + tree1.validate(tree1.root));

        ValidateBST tree2 = new ValidateBST();
        tree2.createValidBinaryTree();
        System.out.println("Is Tree2 valid BST?: " + tree2.validate(tree2.root));
    }
}
