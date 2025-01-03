// We have an array arr[] of size N and an integer K. Find the maximum 
// for each and every contiguous subarray of size K.
// Sample Input 1 : N=9, K=3 arr = 1 2 3 1 4 5 2 3 6
// Sample Output 1 : 3 3 4 5 5 5 6

import java.util.*;

public class MaxOfAllSubArraysOfSizeK {
    public static int[] maxOfAllSubArraysOfSizeK(int arr[], int N, int K) {
        if (N < K || K <= 0) {
            return new int[0]; // Returns an empty array for invalid inputs
        }

        // Result array to store maximums
        int[] result = new int[N - K + 1];
        int resultIndex = 0;

        // Deque to store indices of array elements
        // Maintains elements in decreasing order of values
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - K) {
                deque.pollFirst();
            }
            // Purpose: Ensure the deque only contains indices of elements 
            // within the current window of size K.
            // Explanation: i is the current index.
            // i - K is the index of the element that is just outside the 
            // left boundary of the current window. If the index at the front 
            // of the deque (peekFirst()) is out of the current window 
            // (<= i - K), remove it using pollFirst().
            // Effect: Keeps the deque clean by removing stale indices that 
            // are no longer part of the current window.

            // Remove elements from the back that are smaller than the current element
            // They are no longer useful as the current element is greater
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index
            deque.addLast(i);

            // Add the maximum of the current window to the result
            if (i >= K - 1) { 
                // Start adding to the result array when the first 
                // window of size K is complete
                result[resultIndex++] = arr[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int N = arr.length;
        int K = 3;

        int[] result = maxOfAllSubArraysOfSizeK(arr, N, K);
        System.out.println("Maximum of all subarrays of size " + K + " - ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

// Linear Time Complexity - O(n)