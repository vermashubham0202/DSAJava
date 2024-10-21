package com.pidkui.linkedList.questionsSinglyLinkedList;

public class DetectLoopLinkedList {
    Node head;

    public DetectLoopLinkedList() {
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

    // creating a loop intentionally
    /*

    1 --> 2 --> 3 --> 4 --> 5 --> 6
                ^                 |
                |-----------------|

     */
    public void createLoop(int startKey, int endKey) {
        Node startNode = head;
        Node endNode = head;

        while (startNode.data != startKey) {
            startNode = startNode.next;
        }

        while (endNode.data != endKey) {
            endNode = endNode.next;
        }
        endNode.next = startNode;
    }

    public boolean isLoopPresent() {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectLoopLinkedList linkedList = new DetectLoopLinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(4);
        linkedList.insertNode(5);
        linkedList.insertNode(6);

        linkedList.createLoop(3, 6);
//        linkedList.display();
        System.out.println("Is loop present in list: " + linkedList.isLoopPresent());
    }
}
