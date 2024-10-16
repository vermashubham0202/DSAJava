package com.pidkui.linkedList.questions;

public class MiddleNodeSinglyLinkedList {
    Node head;

    public MiddleNodeSinglyLinkedList() {
        head = null;
    }

    public void insertNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    }

    public void display() {
        Node tempNode = head;

        if (tempNode == null) {
            System.out.println("List is empty");
        } else {
            while (tempNode != null) {
                System.out.print(tempNode.data + " --> ");
                tempNode = tempNode.next;
            }
            System.out.println("null");
        }
    }

    public Node getMiddleNode() {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        MiddleNodeSinglyLinkedList linkedList = new MiddleNodeSinglyLinkedList();
        linkedList.insertNode(11);
        linkedList.insertNode(8);
        linkedList.insertNode(5);
        linkedList.insertNode(7);
        linkedList.insertNode(16);
        linkedList.insertNode(2);
        linkedList.insertNode(18);
        linkedList.display();

        System.out.println("Middle Node of list is: " + linkedList.getMiddleNode().data);
    }
}
