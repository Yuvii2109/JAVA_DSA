/*
    Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

    A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

    A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 
    Example 1 -
        Input - nums = [1,-2,3,-2]
        Output - 3
        Explanation - Subarray [3] has maximum sum 3.

    Example 2 -
        Input - nums = [5,-3,5]
        Output - 10
        Explanation - Subarray [5,5] has maximum sum 5 + 5 = 10.

    Example 3 -
        Input - nums = [-3,-2,-3]
        Output - -2
        Explanation - Subarray [-2] has maximum sum -2.
*/

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int minEnding = nums[0], maxEnding = nums[0];
        int minSoFar = nums[0], maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            int x = nums[i];
            totalSum += x;
            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);
            minEnding = Math.min(x, minEnding + x);
            minSoFar = Math.min(minSoFar, minEnding);
        }
        // If all numbers are negative, maxSoFar is the largest (i.e. least negative) element, and totalSum == minSoFar. In this case, you cannot take wraparound (it’d give 0).
        if (totalSum == minSoFar) {
            return maxSoFar;
        }
        // Otherwise, the answer is either -
        // a) maxSoFar (best non‑circular subarray)
        // b) totalSum - minSoFar (best circular subarray = total minus the “worst” middle segment)
        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}