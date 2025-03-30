/*
    Given the head of a linked list and an integer val, remove all the 
    nodes of the linked list that has Node.val == val, and return the new 
    head.

    Example 1 -
        Input - head = [1,2,6,3,4,5,6], val = 6
        Output - [1,2,3,4,5]

    Example 2 -
        Input - head = [], val = 1
        Output - []

    Example 3 -
        Input - head = [7,7,7,7], val = 7
        Output - []
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class RemoveLinkedListElements {
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
    public ListNode removeElements(ListNode head, int val) {
        /*
            if(head == null){
                return null;
            }
            // Remove elements from the beginning that match val
            while(head != null && head.val == val){
                head = head.next;
            }
            ListNode current = head;
            while(current != null && current.next != null){
                if(current.next.val == val){
                    current.next = current.next.next;
                }
                current = current.next;
            }
            return head;
        */

        // Above code not working properly for the cases like [1, 2, 2, 1] so, let's try something else and create a dummy LinkedList - 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null){
            if(current.next.val == val){
                current.next = current.next.next; // Skipping the node with value == val
            }else{
                current = current.next; // Moving forward in case of no deletion
            }
        }
        return dummy.next;
    }
}