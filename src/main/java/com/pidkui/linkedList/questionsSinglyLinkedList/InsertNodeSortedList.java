package com.pidkui.linkedList.questionsSinglyLinkedList;

public class InsertNodeSortedList {
    Node head;

    public InsertNodeSortedList() {
        head = null;
    }

    public void insertNodeSorted(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else if(head.data > newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node currentNode = head;
            Node previousNode = null;
            while (currentNode != null && currentNode.data < newNode.data) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            previousNode.next = newNode;
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

    public static void main(String[] args) {
        InsertNodeSortedList linkedList = new InsertNodeSortedList();
        linkedList.insertNodeSorted(2);
        linkedList.insertNodeSorted(7);
        linkedList.insertNodeSorted(14);
        linkedList.insertNodeSorted(4);
        linkedList.insertNodeSorted(11);
        linkedList.insertNodeSorted(1);
        linkedList.display();
    }
}
