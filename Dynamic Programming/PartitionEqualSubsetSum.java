/*
    Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

    Example 1 -
        Input - nums = [1,5,11,5]
        Output - true
        Explanation - The array can be partitioned as [1, 5, 5] and [11].

    Example 2 -
        Input - nums = [1,2,3,5]
        Output - false
        Explanation - The array cannot be partitioned into equal sum subsets.
*/

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int x : nums) total += x;
        if((total & 1) == 1) return false; // If sum of all elements is odd, then return false (odd numbers cannot be divided equally)
        int target = total/2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base cases -
        // With zero items (i=0), only sum=0 is achievable.
        // For any i, sum=0 is always achievable (pick nothing).
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        // (dp[0][s>0] stays false by default)
        for(int i = 1; i <= n; i++){
            int num = nums[i - 1];
            for(int s = 1; s <= target; s++){
                // Option 1 - Don’t take nums[i-1]
                dp[i][s] = dp[i - 1][s];
                // Option 2 - Take nums[i-1], if it fits
                if (s >= num && dp[i - 1][s - num]) {
                    dp[i][s] = true;
                }
            }
        }
        return dp[n][target];
    }
}