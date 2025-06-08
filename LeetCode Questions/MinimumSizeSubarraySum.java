/*
    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead. 

    Example 1 -
        Input - target = 7, nums = [2,3,1,2,4,3]
        Output - 2
        Explanation - The subarray [4,3] has the minimal length under the problem constraint.

    Example 2 -
        Input - target = 4, nums = [1,4,4]
        Output - 1

    Example 3 -
        Input - target = 11, nums = [1,1,1,1,1,1,1,1]
        Output - 0
*/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            sum += nums[right];
            // While current window [left..right] meets or exceeds target, try to shrink it from the left to find a smaller valid window
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++]; // Remove nums[left] from sum and move left forward
            }
        }
        // If we never found a valid window, return 0
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}