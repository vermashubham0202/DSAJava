package com.pidkui.queue;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class QueueUsingLinkedList {
    Node front;
    Node rear;
    int length;

    public QueueUsingLinkedList() {
        front = null;
        rear = null;
        length = 0;
    }

    private void enqueue(int data) {
    }

    private Node dequeue() {
        return null;
    }

    private int getLength() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {

    }
}
