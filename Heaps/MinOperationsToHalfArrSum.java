// Minimum Operations to Halve Array Sum
// We have an array Arr[], the task is to nd out the minimum number of 
// operations to make the sum of array elements lesser or equal to half 
// of its initial value. In one such operation, it is allowed to half the 
// value of any array element.
// Sample Input 1 - [1, 5, 8, 19]
// Sample Output 1 - 3
// Solve this question using priority queues or heaps

import java.util.PriorityQueue;
import java.util.Collections;

public class MinOperationsToHalfArrSum {
    public static int minOperations(double[] arr) {
        // Priority queue for max-heap
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Calculate the initial sum
        double initialSum = 0;
        for (double num : arr) {
            initialSum += num;
            maxHeap.add(num);
        }

        // Target to achieve (half of initial sum)
        double targetSum = initialSum / 2;

        // Current reduced sum
        double reducedSum = initialSum;
        int operations = 0;

        // Process the max-heap
        while (reducedSum > targetSum) {
            // Get the largest element
            double largest = maxHeap.poll();

            // Halve the largest element
            double reducedValue = largest / 2;

            // Update the reduced sum
            reducedSum -= reducedValue;

            // Add the reduced value back to the heap
            maxHeap.add(reducedValue);

            // Increment the operations count
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5, 8, 19};
        System.out.println("Minimum operations - " + minOperations(arr));
    }
}

// Time complexity - O(NlogN)
// Space complexity - O(N)