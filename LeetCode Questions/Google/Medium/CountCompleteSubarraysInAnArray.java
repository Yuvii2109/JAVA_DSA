/*
    You are given an array nums consisting of positive integers. We call a subarray of an array complete if the following condition is satisfied -
        The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array. Return the number of complete subarrays.

    A subarray is a contiguous non-empty part of an array.   

    Example 1 -
        Input - nums = [1,3,1,2,2]
        Output - 4
        Explanation - The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].

    Example 2 -
        Input - nums = [5,5,5,5]
        Output - 10
        Explanation - The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>(); // Computing total distinct elements in entire array
        for(int x : nums){
            set.add(x);
        }
        int k = set.size();
        return atMost(nums, k) - atMost(nums, k-1);
    }
    // Returns the number of subarrays with at most K distinct elements.
    private int atMost(int A[], int k){
        if(k < 0) return 0; // No subarray can have negative distinct elements.
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0, left = 0, distinctCount = 0;
        for(int right = 0; right < A.length; right++){
            int x = A[right];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if(freq.get(x) == 1){
                distinctCount++;
            }
            // Shrink window until we have ≤ K distinct elements
            while(distinctCount > k){
                int y = A[left];
                freq.put(y, freq.get(y) - 1);
                if(freq.get(y) == 0){
                    distinctCount--;
                }
                left++;
            }
            // All subarrays ending at `right` with start in [left..right] are valid, Count = window size = (right - left + 1)
            res += right - left + 1;
        }
        return res;
    }
}