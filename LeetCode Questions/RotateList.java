/*
    Given the head of a linked list, rotate the list to the right by k places. 

    Example 1 - 
        Input - head = [1,2,3,4,5], k = 2
        Output - [4,5,1,2,3]

    Example 2 -
        Input - head = [0,1,2], k = 4
        Output - [2,0,1]
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        // Computing length and making the LinkedList Circular
        ListNode tail = head;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        tail.next = head;
        // Find the new tail - (length - (k % length))th node
        // New head - its next
        k %= length;
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewTail; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */