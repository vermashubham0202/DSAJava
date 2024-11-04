package com.pidkui.linkedList;

class CListNode {
    int data;
    CListNode next;

    public CListNode(int data) {
        this.data = data;
    }
}

public class CircularSinglyLinkedList {
    CListNode last;
    int listLength;

    public CircularSinglyLinkedList() {
        last = null;
        listLength = 0;
    }

    private void insertNode(int data) {
        CListNode newNode = new CListNode(data);

        if (isEmpty()) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        listLength++;
    }

    private void insertNodeAtStart(int data) {
        CListNode newNode = new CListNode(data);

        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        listLength++;
    }

    private CListNode deleteFirstNode() {

        if (isEmpty()) {
            return null;
        }

        CListNode firstNode = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = firstNode.next;
        }
        firstNode.next = null;
        listLength--;
        return firstNode;
    }

    private int getListLength() {
        return listLength;
    }

    private boolean isEmpty() {
//        return last == null;
        return listLength == 0;
    }

    private void display() {
        if (last == null) {
            System.out.println("List is empty!");
        } else {
            CListNode tempNode = last.next;
            while (tempNode != last) {
                System.out.print(tempNode.data + " --> ");
                tempNode = tempNode.next;
            }
            System.out.println(tempNode.data + " --> repeat --> " + tempNode.next.data + "...");
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList linkedList = new CircularSinglyLinkedList();
        linkedList.insertNode(5);
        linkedList.insertNode(10);
        linkedList.insertNode(15);
        linkedList.insertNode(20);
        linkedList.insertNode(25);
        linkedList.display();


//        linkedList.insertNodeAtStart(2);

//        CListNode deletedNode = linkedList.deleteFirstNode();
//        if (deletedNode == null) {
//            System.out.println("List is empty.");
//        } else {
//            System.out.println("Deleted node is: " + deletedNode.data);
//        }

        System.out.println("--- After Operation ---");
        linkedList.display();
    }
}
