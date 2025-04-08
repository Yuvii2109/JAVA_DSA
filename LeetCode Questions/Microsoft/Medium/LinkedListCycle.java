/*
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter. Do not modify the linked list. 

    Example 1 - 
        Input - head = [3,2,0,-4], pos = 1
        Output - tail connects to node index 1
        Explanation - There is a cycle in the linked list, where tail connects to the second node.

    Example 2 - 
        Input - head = [1,2], pos = 0
        Output - tail connects to node index 0
        Explanation - There is a cycle in the linked list, where tail connects to the first node.

    Example 3 - 
        Input - head = [1], pos = -1
        Output - no cycle
        Explanation - There is no cycle in the linked list.
*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(hasCycle){
            ListNode pointer1 = head; // pointer1 starts from head
            ListNode pointer2 = slow; // // pointer2 starts from the meeting point
            while(pointer1 != pointer2){
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            return pointer1; // pointer1 now points to the cycle
        }else{
            return null; // No cycle found
        }
    }
}