// Merge K Sorted Linked List
// We have K linked lists each of size N and each list is sorted in 
// non-decreasing order, merge them into a single sorted (non-decreasing 
// order) linked list and print the sorted linked list as output.
// Sample Input 1 -
// K=3, N=3 
// list1 = 1 -> 3 ->7 -> NULL
// list2 = 2 -> 4 ->8 -> NULL
// list3 = 9 -> 10 ->11 -> NULL
// Sample Output 1 - 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9 -> 10 -> 11

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLL {
    static class NodeComparator implements Comparable<NodeComparator> {
        ListNode node;

        NodeComparator(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(NodeComparator other) {
            return this.node.val - other.node.val; // Min-heap based on node value
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to store nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        // Dummy node to simplify list construction
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process the heap
        while (!minHeap.isEmpty()) {
            // Extract the smallest node
            ListNode smallest = minHeap.poll();

            // Add it to the result list
            current.next = smallest;
            current = current.next;

            // If the extracted node has a next node, add it to the heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Create input lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(9);
        list3.next = new ListNode(10);
        list3.next.next = new ListNode(11);

        // Array of lists
        ListNode[] lists = {list1, list2, list3};

        // Merge and print
        ListNode mergedHead = mergeKLists(lists);
        printList(mergedHead);
    }
}

// Time complexity - O(N.K.logK)
// Space complexity - O(K)