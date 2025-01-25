// arr = {15, -2, 2, -8, 1, 7, 10, 23}
// Largest subarray with 0 sum = {-2, 2, -8, 1, 7}
// Sum(0, i) - Sum(0, j) = Sum(i, j)

import java.util.HashMap;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0, endIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if the current sum has been seen before in the map
            if (sum == 0) {
                maxLength = i + 1;
                endIndex = i;
            } else {
                if (map.containsKey(sum)) {
                    int startIndex = map.get(sum);
                    int currLength = i - startIndex;
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        endIndex = i;
                    }
                } else {
                    map.put(sum, i);
                }
            }
        }

        // Extract the largest subarray with sum zero
        int startIndex = endIndex - maxLength + 1;
        int[] subarray = new int[maxLength];
        System.arraycopy(arr, startIndex, subarray, 0, maxLength);
        // Copies a portion of an array in someother array

        // Print the length of the largest subarray with sum zero
        System.out.println("Length of largest subarray with sum as 0 - " + maxLength);

        // Print the subarray
        System.out.print("Largest subarray with sum as 0 - [ ");
        for (int num : subarray) {
            System.out.print(num + " ");
        }
        System.out.print("]\n");
    }
}

// Time complexity - O(n)