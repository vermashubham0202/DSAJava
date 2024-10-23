package com.pidkui.linkedList.questionsSinglyLinkedList;
/*
 * Using Out-Of-Place Algorithm.
 * Definition:
 *      Out-of-place algorithms create copies of the input data,
 *      using additional memory for processing.
 */

public class MergeTwoSortedLinkedList {
    Node head;

    public MergeTwoSortedLinkedList() {
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

    public static void mergeSortedLinkedLists(Node head1, Node head2, MergeTwoSortedLinkedList mergedLinkedList) {

        Node tempNode1 = head1;
        Node tempNode2 = head2;

        while (tempNode1 != null && tempNode2 != null) {
            if(tempNode1.data < tempNode2.data) {
                mergedLinkedList.insertNode(tempNode1.data);
                tempNode1 = tempNode1.next;
            } else {
                mergedLinkedList.insertNode(tempNode2.data);
                tempNode2 = tempNode2.next;
            }
        }

        while(tempNode1 != null) {
            mergedLinkedList.insertNode(tempNode1.data);
            tempNode1 = tempNode1.next;
        }

        while(tempNode2 != null) {
            mergedLinkedList.insertNode(tempNode2.data);
            tempNode2 = tempNode2.next;
        }
    }
    
    public static void main(String[] args) {
        MergeTwoSortedLinkedList linkedList1 = new MergeTwoSortedLinkedList();
        linkedList1.insertNode(6);
        linkedList1.insertNode(9);
        linkedList1.insertNode(15);
        linkedList1.insertNode(17);
        linkedList1.insertNode(19);
        System.out.println("Sorted linked list-1:");
        linkedList1.display();

        MergeTwoSortedLinkedList linkedList2 = new MergeTwoSortedLinkedList();
        linkedList2.insertNode(5);
        linkedList2.insertNode(10);
        linkedList2.insertNode(16);
        System.out.println("Sorted linked list-2:");
        linkedList2.display();
        
        System.out.println("--- After Operation ---");
        MergeTwoSortedLinkedList mergedLinkedList = new MergeTwoSortedLinkedList();
        mergeSortedLinkedLists(linkedList1.head, linkedList2.head, mergedLinkedList);
        mergedLinkedList.display();
    }
}
