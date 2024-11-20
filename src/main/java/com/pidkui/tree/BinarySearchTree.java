package com.pidkui.tree;
/*
- A Binary Search Tree (BST) is a tree data structure where each node has at most two children: left and right.
- Properties:
  1. The left subtree contains only nodes with values less than the parent node.
  2. The right subtree contains only nodes with values greater than the parent node.
  3. The left and right subtree each must also be a Binary Search Tree.
  4. No duplicate values are allowed (in a strict BST).
- Commonly used for efficient searching, insertion, and deletion operations.
 */

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    private void insert(int data) {
        root = insertTreeNode(root, data);
    }

    private TreeNode insertTreeNode(TreeNode root, int data) {
        if (root == null) {  // base condition
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertTreeNode(root.left, data);
        } else {
            root.right = insertTreeNode(root.right, data);
        }
        return root;
    }

    private boolean isSearchKeyPresent(int key) {
        if (searchKey(root, key) == null) {
            return false;
        }
        return true;
    }

    private TreeNode searchKey(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            return searchKey(root.left, key);
        } else {
            return searchKey(root.right, key);
        }
    }

    // when we do In-Order traversal of BST,
    // then the values will be printed in sorted format
    private void recursiveInOrderTraversal(TreeNode root) {
        if (root == null) { // base condition
            return;
        }
        recursiveInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        recursiveInOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(8);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);

        System.out.println("InOrder Traversal:");
        binarySearchTree.recursiveInOrderTraversal(binarySearchTree.root);
        System.out.println();

        int searchKey1 = 10;
        System.out.println("Is search key " + searchKey1 + " present? : " + binarySearchTree.isSearchKeyPresent(searchKey1));

        int searchKey2 = 5;
        System.out.println("Is search key " + searchKey2 + " present? : " + binarySearchTree.isSearchKeyPresent(searchKey2));
    }
}
