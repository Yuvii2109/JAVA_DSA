/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1 -
        Input - head = [1,2,3,4,5]
        Output - [5,4,3,2,1]

    Example 2 -
        Input - head = [1,2]
        Output - [2,1]

    Example 3 -
        Input - head = []
        Output - []
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class ReverseALinkedList {
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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
}