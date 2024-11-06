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
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    private int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        int dequeuedValue = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        length--;
        return dequeuedValue;
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            Node tempNode = front;
            while (tempNode != null) {
                System.out.print(tempNode.data + " --> ");
                tempNode = tempNode.next;
            }
            System.out.println("null");
        }
    }

    private int first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return front.data;
    }

    private int last() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return rear.data;
    }

    private int getLength() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println("First Node: " + queue.first());
        System.out.println("Last Node: " + queue.last());

        System.out.println("Deleted Node: " + queue.dequeue());

        System.out.println("--- After Operation ---");
        queue.display();
    }
}
