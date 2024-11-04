package com.pidkui.stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class StackUsingLinkedList {
    Node top;
    int length;

    public StackUsingLinkedList() {
        top = null;
        length = 0;
    }

    private void push(int data) {
        Node tempNode = new Node(data);
        tempNode.next = top;
        top = tempNode;
        length++;
    }

    private int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int popValue = top.data;
        top = top.next;
        length--;
        return popValue;
    }

    private int peek() {
        // returning last inserted node into the stack
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    private int getStackElementsCount() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(2);
        stack.push(16);
        stack.push(18);
        stack.push(13);
        stack.push(21);
        stack.push(27);

        System.out.println("Stack's top value: " + stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
