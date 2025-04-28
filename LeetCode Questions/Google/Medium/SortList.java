/*
    Given the head of a linked list, return the list after sorting it in ascending order.

    Example 1 -
        Input - head = [4,2,1,3]
        Output - [1,2,3,4]

    Example 2 -
        Input - head = [-1,5,3,4,0]
        Output - [-1,0,3,4,5]

    Example 3 -
        Input - head = []
        Output - []
*/

public class SortList {
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
    public ListNode sortList(ListNode head) {
        // Empty list or singleton is already sorted - 
        if(head == null || head.next == null) return head;

        // Split list into two halves - 
        ListNode mid = split(head);
        ListNode left = head, right = mid;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    // Using slow-fast approach
    private ListNode split(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Cut the list in two
        prev.next = null;
        return slow;
    }

    // Merge two sorted lists and return head of merged list
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0), tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // Appending any remaining nodes - 
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}