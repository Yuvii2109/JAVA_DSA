import java.lang.classfile.components.ClassPrinter.ListNode;

public class MergeTwoSortedLists{
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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     ListNode node = new ListNode(-1);
    //     while(list1 != null){
    //         pq.add(list1.val);
    //         list1 = list1.next;
    //     }
    //     while(list2 != null){
    //         pq.add(list2.val);
    //         list2 = list2.next;
    //     }
    //     ListNode current = node;
    //     while(!pq.isEmpty()){
    //         current.next = new ListNode(pq.poll());
    //         current = current.next;
    //     }
    //     return node.next;
    // }
    // Not optimal approach
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode current = node;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2; 
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        }
        if(list2 != null){
            current.next = list2;
        }
        return node.next;
    }
}