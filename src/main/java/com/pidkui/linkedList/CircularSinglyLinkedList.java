package com.pidkui.linkedList;

class DataNode {
    int data;
    DataNode next;

    public DataNode(int data) {
        this.data = data;
    }
}

public class CircularSinglyLinkedList {
    DataNode last;
    int listLength;

    public CircularSinglyLinkedList() {
        last = null;
        listLength = 0;
    }

    private void insertNode(int data) {
        DataNode newNode = new DataNode(data);

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
            DataNode tempNode = last.next;
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
    }
}
