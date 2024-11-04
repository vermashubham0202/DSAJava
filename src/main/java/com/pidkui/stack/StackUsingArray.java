package com.pidkui.stack;

import java.util.EmptyStackException;

public class StackUsingArray {

    int top;
    int[] stack;

    public StackUsingArray(int capacity) {
        top = -1;
        stack = new int[capacity];
    }

    public StackUsingArray() {
        this(10);   // default capacity
    }

    private void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Can't insert: " + data + ", Stack is full!");
        }
        top++;
        stack[top] = data;
    }

    private int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int popValue = stack[top];
        top--;
        return popValue;
    }

    private int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    private boolean isFull() {
        return stack.length == getStackSize();
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private int getStackSize() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(2);
        stack.push(16);
        stack.push(18);
        stack.push(21);
        stack.push(27);

        System.out.println("Stack's top value: " + stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
