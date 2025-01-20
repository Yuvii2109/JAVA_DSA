// Find the maximum of all subarrays of size k

import java.util.PriorityQueue;

public class SlidingWindowMax {
    public static class Subarrays implements Comparable<Subarrays> {
        int value; 
        int index;
        
        public Subarrays(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        @Override
        public int compareTo(Subarrays other) {
            if (this.value != other.value) {
                return Integer.compare(other.value, this.value); 
                // Sort by value descending
            } else {
                return Integer.compare(this.index, other.index); 
                // Ascending order by index (tie-breaking)
                // Agar values same hain toh index ke basis par tie break hoga
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new int[arr.length - k + 1];
        PriorityQueue<Subarrays> pq = new PriorityQueue<>();
        
        // Initialize the priority queue with the first k elements
        for (int i = 0; i < k; i++) {
            pq.add(new Subarrays(arr[i], i));
        }
        // At this stage, the PriorityQueue contains all the elements of 
        // the first window, sorted such that the largest element is at 
        // the top (pq.peek()).
        
        // Process each element from index k to the end of array
        for (int i = k; i < arr.length; i++) {
            // Add the maximum of the current window to result
            result[i - k] = pq.peek().value;
            
            // Add the new element to the priority queue
            pq.add(new Subarrays(arr[i], i));
            
            // Remove the element which is out of the current window
            pq.remove(new Subarrays(arr[i - k], i - k));
        }
        
        // Add the maximum of the last window to result
        result[arr.length - k] = pq.peek().value;
        
        // Print the result
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

// Time Complexity - O(nlogk), where n is the size of the array and k is the window size.
// Space Complexity - O(k), as the PriorityQueue holds at most k elements.