package com.pidkui.linkedList.questions;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseSinglyLinkedList {
    Node head;

    public ReverseSinglyLinkedList() {
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

    public void reverseList() {
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    public static void main(String[] args) {
        ReverseSinglyLinkedList linkedList = new ReverseSinglyLinkedList();
        linkedList.insertNode(11);
        linkedList.insertNode(8);
        linkedList.insertNode(5);
        linkedList.insertNode(7);
        linkedList.insertNode(16);
        linkedList.display();

        System.out.println("--- After Operation ---");
        linkedList.reverseList();
        linkedList.display();
    }
}
