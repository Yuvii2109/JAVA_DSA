// Split the given array into K sub-arrays -
// We have an Array[] of N elements and a number K. (1 <= K <=N). Split 
// the given array into K subarrays (they must cover all the elements). 
// The maximum subarray sum achievable out of K subarrays formed must be 
// the minimum possible. Find that possible subarray sum.
// Sample Input 1 - Array[] = {1, 1, 2} K = 2
// Sample Output 1 - 2
// Sample Input 2 - Array[] = {1, 2, 3, 4}, K = 3
// Sample Output 2 - 4

public class SplitIntoKSubarrays {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 2};
        int K1 = 2;
        int[] array2 = {1, 2, 3, 4};
        int K2 = 3;

        System.out.println("Minimum possible maximum subarray sum - " + splitArray(array1, K1)); 
        System.out.println("Minimum possible maximum subarray sum - " + splitArray(array2, K2)); 
    }

    public static int splitArray(int[] nums, int K) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        // This method computes the minimum possible maximum subarray sum 
        // using binary search. Variables -
        // low - The smallest possible value for the maximum subarray sum. 
        // Initialized to the smallest possible integer value.
        // high - The largest possible value for the maximum subarray sum, 
        // initialized to 0 (will later store the sum of all elements).

        // Find the range for binary search
        for (int num : nums) {
            low = Math.max(low, num); // Maximum element
            high += num; // Sum of all elements
        }
        // low - The maximum element in the array, because no subarray can 
        // have a sum smaller than the largest element.
        // high - The sum of all elements, representing the case where the 
        // array is not split.

        // Binary search
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if it's possible to split with max subarray sum <= mid
            if (canSplit(nums, K, mid)) {
                high = mid; // Try for a smaller maximum sum
            } else {
                low = mid + 1; // Increase the allowed maximum sum
            }
        }
        // Perform binary search to find the smallest possible maximum 
        // subarray sum - Compute mid as the average of low and high.
        // Use the helper method canSplit to check if it is possible to split 
        // the array into K subarrays with a maximum subarray sum ≤ mid
        // Update -
        // If splitting is possible with mid, move high = mid to search for 
        // smaller values.
        // If splitting is not possible, increase low = mid + 1.

        return low;
        // When binary search completes, low holds the smallest possible 
        // maximum subarray sum.
    }

    // Helper function to check if we can split into K subarrays with max sum <= target
    public static boolean canSplit(int[] nums, int K, int target) {
        int subarrayCount = 1;
        int currentSum = 0;
        // Check if the array can be split into K subarrays with a maximum 
        // subarray sum ≤ target. Variables -
        // subarrayCount - Tracks the number of subarrays formed (initialized 
        // to 1 since we start with one subarray).
        // currentSum - Tracks the sum of the current subarray.

        for (int num : nums) {
            currentSum += num;

            if (currentSum > target) {
                // Start a new subarray
                subarrayCount++;
                currentSum = num;

                // If we exceed K subarrays, return false
                if (subarrayCount > K) {
                    return false;
                }
            }
        }
        return true;
        // Iterate over the array and try to form subarrays while ensuring 
        // their sum does not exceed target -
        // Add the current element to currentSum.
        // If currentSum > target:
        // Increment subarrayCount (start a new subarray).
        // Reset currentSum to the current element.
        // If the number of subarrays exceeds K, return false (splitting is 
        // not possible).
        // If the loop completes and ≤ K subarrays are formed, return true.
    }   
}

// Time complexity - O(Nlog(sum−max)) = O(Nlogn)