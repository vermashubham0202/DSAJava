package com.pidkui.linkedList.questionsSinglyLinkedList;
/*
 * Using In-place Algorithm.
 * Definition:
 *      In-place algorithms modify the input data directly without requiring extra memory.
 */

public class MergeTwoSortedLinkedList2 {
    Node head;

    public MergeTwoSortedLinkedList2() {
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

    private static Node mergeSortedLists(Node head1, Node head2) {
        Node dummy = new Node(Integer.MIN_VALUE);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if(head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedList2 linkedList1 = new MergeTwoSortedLinkedList2();
        linkedList1.insertNode(6);
        linkedList1.insertNode(9);
        linkedList1.insertNode(15);
        linkedList1.insertNode(17);
        linkedList1.insertNode(19);
        System.out.println("Sorted linked list-1:");
        display(linkedList1.head);

        MergeTwoSortedLinkedList2 linkedList2 = new MergeTwoSortedLinkedList2();
        linkedList2.insertNode(5);
        linkedList2.insertNode(10);
        linkedList2.insertNode(16);
        System.out.println("Sorted linked list-2:");
        display(linkedList2.head);
        
        System.out.println("--- After Operation ---");
        Node mergedListHead = mergeSortedLists(linkedList1.head, linkedList2.head);
        display(mergedListHead);
    }
}
