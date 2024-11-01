package com.pidkui.linkedList;

class ListNode {
    ListNode previous;
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    int listLength = 0;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    private void insertNode(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        listLength++;
    }

    private void insertNodeAtStart(int data) {
        ListNode newNode = new ListNode(data);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        listLength++;
    }

    private ListNode deleteFirstNode() {
        if (isEmpty()) {
            return null;
        }

        ListNode tempNode = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        tempNode.next = null;
        listLength--;
        return tempNode;
    }

    private ListNode deleteLastNode() {
        if (isEmpty()) {
            return null;
        }

        ListNode tempNode = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        tempNode.previous = null;
        listLength--;
        return tempNode;
    }

    private boolean isEmpty() {
//        return head == null;
        return listLength == 0;
    }

    private int getListLength() {
        return listLength;
    }

    private void display() {
        ListNode tempNode = head;

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

    private void displayReverse() {
        ListNode tempNode = tail;

        if (tempNode == null) {
            System.out.println("List is empty");
        } else {
            while (tempNode != null) {
                System.out.print(tempNode.data + " --> ");
                tempNode = tempNode.previous;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(10);
        linkedList.insertNode(15);
        linkedList.insertNode(25);

        System.out.println("Forward Traverse:");
        linkedList.display();

//        System.out.println("Backward Traverse:");
//        linkedList.displayReverse();

//        linkedList.insertNodeAtStart(45);

//        ListNode deletedNode = linkedList.deleteFirstNode();
//        if(deletedNode == null) {
//            System.out.println("List is empty.");
//        } else {
//            System.out.println("Deleted node is: " + deletedNode.data);
//        }

//        ListNode deletedNode = linkedList.deleteLastNode();
//        if (deletedNode == null) {
//            System.out.println("List is empty.");
//        } else {
//            System.out.println("Deleted node is: " + deletedNode.data);
//        }

        System.out.println("--- After Operation ---");
        linkedList.display();
    }
}
