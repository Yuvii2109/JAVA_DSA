/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head. 

    Example 1 - 
        Input - head = [1,2,3,4,5], n = 2
        Output - [1,2,3,5]

    Example 2 -
        Input - head = [1], n = 1
        Output - []

    Example 3 -
        Input - head = [1,2], n = 1
        Output - [1]
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class RemoveNthNodeFromTheEndOfTheList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        // If we need to remove the very first node
        if (n == length) {
            return head.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        for (int i = 0; i < length - n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}