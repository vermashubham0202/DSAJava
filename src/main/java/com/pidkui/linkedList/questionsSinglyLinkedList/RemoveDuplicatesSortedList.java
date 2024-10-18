package com.pidkui.linkedList.questionsSinglyLinkedList;

public class RemoveDuplicatesSortedList {
    Node head;

    public RemoveDuplicatesSortedList() {
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

    public void removeDuplicate() {
        Node currentNode = head;

        while(currentNode != null && currentNode.next != null) {
            if(currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedList linkedList = new RemoveDuplicatesSortedList();
        linkedList.insertNode(2);
        linkedList.insertNode(4);
        linkedList.insertNode(4);
        linkedList.insertNode(4);
        linkedList.insertNode(5);
        linkedList.insertNode(6);
        linkedList.insertNode(6);
        linkedList.insertNode(10);
        linkedList.insertNode(11);
        linkedList.insertNode(11);
        linkedList.display();

        System.out.println("--- After Operation ---");
        linkedList.removeDuplicate();
        linkedList.display();
    }
}
