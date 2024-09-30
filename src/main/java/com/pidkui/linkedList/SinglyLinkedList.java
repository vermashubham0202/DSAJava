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

    public void insertNodeAtPosition(int position, int data) {
        Node newNode = new Node(data);

        if(position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previousNode = head;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.next;
                count++;
            }
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
    }

    public Node deleteFirstNode() {
        if(head == null) {
            return null;
        }
        Node tempNode = head;
        head = head.next;
        tempNode.next = null;
        return tempNode;
    }

    public Node deleteLastNode() {
        if(head == null || head.next == null) {
            Node tempNode = head;
            head = null;
            return tempNode;
        }

        Node previousNode = null;
        Node currentNode = head;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = null;
        return currentNode;
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

        singlyLinkedList.insertNodeAtPosition(5, 18);

        singlyLinkedList.display();

//        System.out.println("Deleted Last Node is: " + singlyLinkedList.deleteLastNode().data);
//        singlyLinkedList.display();

//        System.out.println("Deleted First Node is: " + singlyLinkedList.deleteFirstNode().data);
//        singlyLinkedList.display();

        System.out.println("Length of Singly Linked List: " + singlyLinkedList.lengthOfLinkedList());
    }
}
