/*
    The distance of a pair of integers a and b is defined as the absolute 
    difference between a and b. Given an integer array nums and an integer 
    k, return the kth smallest distance among all the pairs nums[i] and 
    nums[j] where 0 <= i < j < nums.length.

    Example 1 -
        Input - nums = [1,3,1], k = 1
        Output - 0
        Explanation - Here are all the pairs -
        (1,3) -> 2
        (1,1) -> 0
        (3,1) -> 2
        Then the 1st smallest distance pair is (1,1), and its distance is 0.

    Example 2 - 
        Input - nums = [1,1,1], k = 2
        Output - 0

    Example 3 - 
        Input - nums = [1,6,1], k = 3
        Output - 5
*/

import java.util.*;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); // Helps in efficiently finding and counting distances between pairs
        int n = nums.length;
        int left = 0, right = nums[n-1] - nums[0]; // Right => Maximum possible distance
        while(left < right){
            int mid = left + (right-left)/2;
            int count = countPairs(nums, mid);
            if(count < k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        // Instead of generating all pair distances and sorting them (which is inefficient), we use binary search on the possible distance values.
        // Binary Search Process - 
            // Search for the kth smallest distance within the range [0, right].
            // Midpoint (mid) represents a possible kth smallest distance.
            // Count how many pairs have a distance ≤ mid using the countPairs() function.
            // If there are fewer than k pairs, it means mid is too small, so we increase left = mid + 1.
            // If there are at least k pairs, it means mid might be the answer, so we decrease right = mid.
        return left;
    }
    private int countPairs(int nums[], int maxDistance){
        int count = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > maxDistance){
                left++;
            }
            count += right-left; // Count pairs with distance <= maxDistance
        }
        return count;
    }
}

/*
    Let's dry run the given code with nums = [1, 6, 1] and k = 3 to understand how it finds the kth smallest distance.

    Step 1 - Sorting the Array
        The first step is sorting nums - 
            nums = [1, 1, 6]
            Now, the smallest distance possible (left) is 0 and the maximum possible distance (right) is - 
                right = nums[2] - nums[0] = 6 - 1 = 5

    Step 2 - Binary Search for the Kth Smallest Distance
        Now, we perform binary search on the range [0, 5].
        Iteration 1 - 
            Calculate mid -> mid = (0 + 5) / 2 = 2
            Count pairs with distance ≤ 2 (using countPairs(nums, 2)) - 
                right = 0, left = 0 → no pairs yet
                right = 1, left = 0 → (1,1), distance = 0, count = 1
                right = 2, left = 0 → (1,6) distance = 5 (too large, move left)
                right = 2, left = 1 → (1,6) distance = 5 (still too large, move left)
                right = 2, left = 2 → (6,6) is invalid (no valid pairs)
            Total count = 1
            Since count = 1 < k, increase left - 
                left = mid + 1 = 3

        Iteration 2 -
            Calculate mid -> mid = (3 + 5) / 2 = 4
            Count pairs with distance ≤ 4 (countPairs(nums, 4)) - 
                right = 0, left = 0 → no pairs yet
                right = 1, left = 0 → (1,1), distance = 0, count = 1
                right = 2, left = 0 → (1,6) distance = 5 (too large, move left)
                right = 2, left = 1 → (1,6) distance = 5 (still too large, move left)
                right = 2, left = 2 → (6,6) is invalid (no valid pairs)
            Total count = 1
            Since count = 1 < k, increase left - 
                left = mid + 1 = 5

        Iteration 3 - 
            Calculate mid -> mid = (5 + 5) / 2 = 5
            Count pairs with distance ≤ 5 (countPairs(nums, 5)) - 
                right = 0, left = 0 → no pairs yet
                right = 1, left = 0 → (1,1), distance = 0, count = 1
                right = 2, left = 0 → (1,6) distance = 5, count = 2
                right = 2, left = 1 → (1,6) distance = 5, count = 3
            Total count = 3
            Since count = 3 >= k, decrease right -
                right = mid = 5

    Step 3 - Final Answer
        Since left and right converge (left == right == 5), return left -
            return 5
            Final Output - Output - 5
    The 3rd smallest distance in [1, 6, 1] is 5.
*/