/*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it. 

    Example 1 -
        Input - lists = [[1,4,5],[1,3,4],[2,6]]
        Output - [1,1,2,3,4,4,5,6]
        Explanation - The linked-lists are -
            [
                1->4->5,
                1->3->4,
                2->6
            ]
        merging them into one sorted list -
        1->1->2->3->4->4->5->6

    Example 2 -
        Input - lists = []
        Output - []

    Example 3 -
        Input - lists = [[]]
        Output - []
*/
import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.PriorityQueue;

public class MergeKSortedLists {
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head != null){
                minHeap.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
            if(smallest.next != null){
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }
}