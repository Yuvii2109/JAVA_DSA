/*
    You are given the head of a singly linked-list. The list can be represented as -
        L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form -
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed. 

    Example 1 -
        Input - head = [1,2,3,4]
        Output - [1,4,2,3]

    Example 2 -
        Input - head = [1,2,3,4,5]
        Output - [1,5,2,4,3]
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class ReorderList {
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
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Split and reverse the second half
        ListNode second = slow.next;
        slow.next = null; // Break the list into two halves
        second = reverseList(second); // Reverse the second half
        // Merge the two halves alternately
        ListNode first = head;
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
}