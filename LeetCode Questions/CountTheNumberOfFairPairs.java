/*
    Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs. A pair (i, j) is fair if - 
        0 <= i < j < n, and
        lower <= nums[i] + nums[j] <= upper

    Example 1 - 
        Input - nums = [0, 1, 7, 4, 4, 5], lower = 3, upper = 6
        Output - 6
        Explanation - There are 6 fair pairs - (0, 3), (0, 4), (0, 5), (1, 3), (1, 4), and (1, 5).

    Example 2 -
        Input - nums = [1, 7, 9, 2, 5], lower = 11, upper = 11
        Output - 1
        Explanation - There is a single fair pair - (2, 3).
*/

import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums); // Sorting so that we can binary-search ranges
        long count = 0;
        for(int i = 0; i < n; i++){
            // For each nums[i], we need j > i with -
            //   lower <= nums[i] + nums[j] <= upper
            // ⇔ (lower − nums[i]) <= nums[j] <= (upper − nums[i])
            long minNeeded = (long)lower - nums[i];
            long maxNeeded = (long)upper - nums[i];
            int left = lowerBound(nums, i+1, n, minNeeded);
            int right = upperBound(nums, i+1, n, maxNeeded);

            // All indices in [left, right) satisfy the condition
            count += (right - left);
        }
        return count;
    }
    // First index in [start, end) where nums[idx] >= target
    private int lowerBound(int[] nums, int start, int end, long target){
        int l = start, r = end;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    // first index in [start, end) where nums[idx] > target
    private int upperBound(int[] nums, int start, int end, long target){
        int l = start, r = end;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}

/*
    Original nums - [0, 1, 7, 4, 4, 5]
    Sorted nums - [0, 1, 4, 4, 5, 7]
                   0  1  2  3  4  5   ← sorted indices
    We’ll keep a running count = 0, and for each i from 0 to 5 we do -
        i = 0 -  
            nums[i] = 0 
            minNeeded = lower − nums[i] = 3 − 0 = 3 
            maxNeeded = upper − nums[i] = 6 − 0 = 6 
            We search among sorted indices 1…5 (values [1, 4, 4, 5, 7]) -
                lowerBound ≥ 3 lands on index 2 (value 4). 
                upperBound > 6 lands on index 5 (value 7), since at index 4 we have 5 ≤ 6, but at index 5 7 > 6. 
                All sorted‐array indices in [2, 5) are valid for pairing with i=0. That gives 5 − 2 = 3 pairs. 
                These correspond (in the original unsorted array) to pairing 0 with the three 4/4/5 elements.

        i = 1 -  
            nums[i] = 1 
            minNeeded = 3 − 1 = 2 
            maxNeeded = 6 − 1 = 5 
            Search among indices 2…5 (values [4, 4, 5, 7]) -
                lowerBound ≥ 2 is still index 2 (4). 
                upperBound > 5 is index 5 (7 > 5). 
                Valid window is [2, 5), again giving 3 pairs. 
                In the original array, that’s pairing the “1” with each of those three values 4,4,5. 

        i = 2 -  
            nums[i] = 4 
            minNeeded = 3 − 4 = −1 
            maxNeeded = 6 − 4 = 2 
            Search among indices 3…5 (values [4, 5, 7]) -
                lowerBound ≥ −1 lands at index 3 (4 ≥ −1). 
                upperBound > 2 also lands at index 3, since 4 > 2 immediately. 
                The interval is [3, 3), zero length ⇒ 0 new pairs. 

        i = 3 -  
            nums[i] = 4 (the second 4) 
            minNeeded = −1, maxNeeded = 2 (same as before) 
            Search in indices 4…5 (values [5, 7]) - 
                lowerBound ≥ −1 is index 4. 
                upperBound > 2 is also index 4 (5 > 2). 
                Interval [4, 4) ⇒ 0 pairs.

        i = 4 -  
            nums[i] = 5 
            minNeeded = 3 − 5 = −2 
            maxNeeded = 6 − 5 = 1 
            Search in index 5…5 (just [7]) -
                lowerBound ≥ −2 is index 5. 
                upperBound > 1 is also index 5 (7 > 1). 
                Interval [5,5) ⇒ 0 pairs.

        i = 5 - 
            nums[i] = 7
            minNeeded = 3 − 7 = −4
            maxNeeded = 6 − 7 = −1
            There are no indices beyond 5, so both bounds return 6 ⇒ interval empty ⇒ 0.
            Adding up all contributions - 
                From i= 0 -> 3
                From i= 1 -> 3
                From i= 2, 3, 4, 5 -> 0
                Total = 6, which matches the expected output.
*/