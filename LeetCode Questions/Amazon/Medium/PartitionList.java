/*
    Given the head of a linked list and a value x, partition it such that 
    all nodes less than x come before nodes greater than or equal to x. 
    You should preserve the original relative order of the nodes in each 
    of the two partitions.

    Example 1 -
        Input - head = [1,4,3,2,5,2], x = 3
        Output - [1,2,2,4,3,5]

    Example 2 -
        Input - head = [2,1], x = 2
        Output - [1,2]
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class PartitionList {
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
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0); // Dummy-List - 1
        ListNode before = before_head;
        ListNode after_head = new ListNode(0); // Dummy-List - 2
        ListNode after = after_head;
        while(head != null){
            if(head.val < x){
                // Agar head ki value target se kam hai then before wali dummy list main add ho jayega
                before.next = head;
                before = before.next;
            }else{
                // Varna after wali dummy list main add ho jayega
                after.next = head;
                after = after.next;
            }
            head = head.next; // aage traverse karta rahega
        }
        after.next = null; // Last node ke baad null karna hoga
        // Merger step -
        before.next = after_head.next;
        return before_head.next; // Before ke node ka head 0 hai isliye usse next wala node return krna hoga
    }
}