/*
A heap in Java is a specialized tree-based data structure that satisfies 
the heap property. There are two main types of heaps -
    Max-Heap - The value of each node is greater than or equal to the 
    values of its children. The largest value is always at the root.
    Min-Heap - The value of each node is less than or equal to the values 
    of its children. The smallest value is always at the root.

Characteristics -
    Heaps are not implemented as a class
    Heaps are often implemented as a binary tree.
    They are typically used to implement priority queues.
    Efficient operations -
        Insertion - O(logn)
        Deletion (removal of root) - O(logn)
        Peek (accessing root) - O(1)

Implementation in Java -
    Java provides a built-in class for heaps called PriorityQueue, 
    which by default implements a min-heap.

Binary Tree - Atmost 2 children

Complete Binary Tree - Binary Tree in which all the levels are completely
filled except possibly the last level, which is filled from left to right.

Heap Order Property -
    Children >= Parent (minHeap)
    Children <= Parent (maxHeap)
*/

import java.util.ArrayList;

public class ImplementationOfHeap {
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        // arr ArrayList - This stores the elements of the heap. The heap 
        // elements are arranged in a way to satisfy the Min-Heap property -
        // For every node at index i, the value of the node is lesser than
        // or equal to its children, which are at indices 2i+1 (left child) 
        // and 2i+2 (right child).
        public void add(int data){
            arr.add(data);
            // arr.add(data) appends the new element to the end of the ArrayList.
            int child = arr.size()-1;
            // int child = arr.size() - 1; gets the index of the newly 
            // added element (last element in the list).
            int parent = (child-1)/2;
            // int parent = (child - 1) / 2; calculates the index of 
            // the parent node. In a binary heap stored in an array -
            // Parent of a node at index i is at (i−1)/2.
            while(child>0 && arr.get(child) < arr.get(parent)){
                int temp = arr.get(child);
                arr.set(child,arr.get(parent));
                arr.set(parent,temp);
                child = parent;
                parent = (child-1)/2;
            }
            // Condition -
            // child > 0 - This ensures that we stop when we reach the 
            // root of the heap (index 0).
            // arr.get(child) < arr.get(parent) - This checks if the 
            // value of the child node is less than its parent. If so, 
            // the Min-Heap property is violated, and we need to swap them.

            // Swapping -
            // Swap the values of the child and parent to move the 
            // smaller value (child) up the heap.
            // temp = arr.get(child) temporarily stores the value of 
            // the child.
            // arr.set(child, arr.get(parent)) assigns the parent's 
            // value to the child's position.
            // arr.set(parent, temp) assigns the stored child value to 
            // the parent's position.

            // Update Indices -
            // After swapping, move the child index to the parent's 
            // position (child = parent).
            // Recalculate the parent index using (child - 1) / 2.

            // Repeat -
            // The process continues until -
            // The child index becomes 0 (root node).
            // The Min-Heap property is satisfied (the child is no 
            // longer smaller than its parent).
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int index){
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index; // assumes current to be smallest
            // Checks if left child exists and is smaller
            if (left < arr.size() && arr.get(left) < arr.get(smallest)) {
                smallest = left;
            }
            // Checks if right child exists and is smaller
            if (right < arr.size() && arr.get(right) < arr.get(smallest)) {
                smallest = right;
            }
            // If smallest is not the current node, swap and recurse
            if (smallest != index) {
                int temp = arr.get(index);
                arr.set(index, arr.get(smallest));
                arr.set(smallest, temp);
                heapify(smallest); // Recursively call heapify on the 
                // updated smallest node index to propagate the heap 
                // property downwards.
            }
        }
        public int poll(){
            // Store the root (smallest element)
            int data = arr.get(0); 

            // Swap first and last -
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Delete the last -
            arr.remove(arr.size()-1);

            // Heapify -
            heapify(0);
            return data; // Returns the smallest element
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(21);
        h.add(5);
        h.add(23);
        h.add(16);
        h.add(19);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.poll();
        }
    }
}