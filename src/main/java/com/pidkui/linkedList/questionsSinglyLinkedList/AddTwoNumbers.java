package com.pidkui.linkedList.questionsSinglyLinkedList;
/*
Read this question in 'add-two-numbers-question.png'
 */

public class AddTwoNumbers {
    Node head;

    public AddTwoNumbers() {
        head = null;
    }

    private void insertNode(int data) {
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

    private static void display(Node head) {
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

    private static Node addNumbers(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tailNode = dummy;
        int carry = 0;

        while (head1 != null || head2 != null) {

            int digit1 = (head1 != null) ? head1.data : 0;
            int digit2 = (head2 != null) ? head2.data : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            tailNode.next = new Node(sum % 10);
            tailNode = tailNode.next;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        if (carry == 1) {
            tailNode.next = new Node(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers firstNumber = new AddTwoNumbers();    // first number = 345
        firstNumber.insertNode(3);
        firstNumber.insertNode(4);
        firstNumber.insertNode(3);
        display(firstNumber.head);

        AddTwoNumbers secondNumber = new AddTwoNumbers();   // second number = 465
        secondNumber.insertNode(5);
        secondNumber.insertNode(6);
        secondNumber.insertNode(6);
        display(secondNumber.head);

        Node result = addNumbers(firstNumber.head, secondNumber.head);
        display(result);
    }
}
