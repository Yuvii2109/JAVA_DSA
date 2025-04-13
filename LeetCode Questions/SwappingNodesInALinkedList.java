/*
    You are given the head of a linked list, and an integer k. Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

    Example 1 - 
        Input - head = [1,2,3,4,5], k = 2
        Output - [1,4,3,2,5]

    Example 2 -
        Input - head = [7,9,6,6,7,8,3,0,9,5], k = 5
        Output - [7,9,6,6,8,7,3,0,9,5]
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class SwappingNodesInALinkedList {
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
    public ListNode swapNodes(ListNode head, int k) {
        // int length = 0;
        // ListNode current = head;
        // while(current != null){
        //     length++;
        //     current = current.next;
        // }
        // ListNode first = head;
        // for(int i = 1; i < k; i++){
        //     first = first.next;
        // }
        // int r = length - k + 1;
        // ListNode second = head;
        // for(int i = 1; i < r; i++){
        //     second = second.next;
        // }
        // int swap = first.val;
        // first.val = second.val;
        // second.val = swap;
        // return head;

        ListNode first = head, second = head, current = head;
        
        // Move 'fast' to the kth node from the beginning
        for(int i = 1; i < k; i++){
            current = current.next;
        }
        first = current; // This is the kth node from the beginning

        // Start another pointer from head, move both until 'fast' reaches the end
        while(current.next != null){
            current = current.next;
            second = second.next; // Now 'second' is the kth node from the end
        }

        // Swapping Time 
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}