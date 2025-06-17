/*
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well. 

    Example 1 - 
        Input - head = [1,2,3,3,4,4,5]
        Output - [1,2,5]

    Example 2 -
        Input - head = [1,1,1,2,3]
        Output - [2,3]
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class RemoveDuplicatesFromSortedListII {
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 'prev' always points to the last node in the result list
        ListNode prev = dummy;
        // 'curr' is our scanner through the original list
        ListNode curr = head;
        while(curr != null){
            // If this node is the start of duplicates - 
            if(curr.next != null && curr.val == curr.next.val){
                int dupVal = curr.val;
                // Skip all nodes with this duplicated value
                while (curr != null && curr.val == dupVal) {
                    curr = curr.next;
                }
                // Link prev to the first non-duplicate
                prev.next = curr;
            }else{
                // No duplication at curr - it's safe to keep
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}