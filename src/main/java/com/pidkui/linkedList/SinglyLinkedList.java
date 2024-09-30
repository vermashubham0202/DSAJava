package com.pidkui.linkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head;

    public SinglyLinkedList() {
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

    public void insertNodeAtStart(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
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

    public int lengthOfLinkedList() {
        Node tempNode = head;
        int count = 0;

        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertNode(11);
        singlyLinkedList.insertNode(8);
        singlyLinkedList.insertNode(5);
        singlyLinkedList.insertNode(7);
        singlyLinkedList.insertNode(16);

        singlyLinkedList.insertNodeAtStart(2);

        singlyLinkedList.display();
        System.out.println("Length of Singly Linked List: " + singlyLinkedList.lengthOfLinkedList());
    }
}
