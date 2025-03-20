/*
    Given the head of a singly linked list, return true if it is a 
    palindrome or false otherwise.

    Example 1 -
    Input - head = [1,2,2,1]
    Output - true

    Example 2 -
    Input - head = [1,2]
    Output - false
*/

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.lang.classfile.components.ClassPrinter.ListNode;

public class PalindromeLinkedList {
    // Slow-Fast Approach
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Slow is the mid point
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode mid = findMid(head);

        // Reversing the second half 
        ListNode previous = null;
        ListNode current = mid;
        ListNode next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        ListNode rightHalfHead = previous;
        ListNode leftHalfHead = head;
        while(rightHalfHead != null){
            if(leftHalfHead.val != rightHalfHead.val){
                return false;
            }
            leftHalfHead = leftHalfHead.next;
            rightHalfHead = rightHalfHead.next;
        }
        return true;
    }
}

/*
    Example 1 -
        Input - head = [1, 2, 2, 1]
        Initialization -
        head is a linked list with nodes - 1 -> 2 -> 2 -> 1
        Find Midpoint (findMid method) -
        slow starts at head (1)
        fast starts at head (1)
        Move slow by 1 step and fast by 2 steps until fast reaches the end:
        slow moves - 1 -> 2
        fast moves - 1 -> 2 (end)
        Midpoint (mid) is 2.

        Reverse Second Half -
        Start reversing from mid (2) -
        current = 2
        previous = null
        Move current through 2 -> 1 -
        Reverse links - 2 -> 1 -> null
        Resulting rightHalfHead after reversal - 1 -> 2 (reversed)

        Compare Halves -
        leftHalfHead (original) - 1 -> 2
        rightHalfHead (reversed) - 1 -> 2
        Compare values iteratively -
        1 == 1 (continue)
        2 == 2 (continue)

        Conclusion -
        Both halves match, so it returns true.

    Example 2 -
        Input - head = [1, 2]
        Initialization -
        head is a linked list with nodes - 1 -> 2
        Find Midpoint (findMid method) -

        slow starts at head (1)
        fast starts at head (1)
        Move slow by 1 step and fast by 2 steps until fast reaches the end -
        slow moves - 1 -> 2
        fast moves - 1 -> (end)
        Midpoint (mid) is 2.
        Reverse Second Half -

        Start reversing from mid (2) -
        current = 2
        previous = null
        Move current through 2 -> null -
        Reverse links - 2 -> null
        Resulting rightHalfHead after reversal - 2
        Compare Halves -

        leftHalfHead (original) - 1 -> 2
        rightHalfHead (reversed) - 2
        Compare values iteratively -
        1 != 2 (return false)
        Conclusion -
        Halves do not match, so it returns false.
*/