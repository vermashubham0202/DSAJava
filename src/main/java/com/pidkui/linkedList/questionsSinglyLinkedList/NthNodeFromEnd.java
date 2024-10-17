package com.pidkui.linkedList.questionsSinglyLinkedList;

public class NthNodeFromEnd {
    Node head;

    public NthNodeFromEnd() {
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

    public Node nodeFromEnd(int position) {
        if(head == null) {
            return null;
        }

        if(position <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        Node slowPointer = head;
        Node fastPointer = head;

        int count = 1;
        while (count < position) {
            if(fastPointer.next == null) {
                throw new IllegalArgumentException("position " + position + " is greater than the number of nodes in list.");
            }
            fastPointer = fastPointer.next;
            count++;
        }
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        NthNodeFromEnd linkedList = new NthNodeFromEnd();
        linkedList.insertNode(11);
        linkedList.insertNode(8);
        linkedList.insertNode(5);
        linkedList.insertNode(7);
        linkedList.insertNode(16);
        linkedList.insertNode(2);
        linkedList.insertNode(18);
        linkedList.display();

        int position = 3;
        System.out.println(position + " last node from end in list is: " + linkedList.nodeFromEnd(position).data);
    }
}
