/*
    Given an integer array nums, return the length of the longest strictly increasing subsequence. 

    Example 1 -
        Input - nums = [10,9,2,5,3,7,101,18]
        Output - 4
        Explanation - The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Example 2 -
        Input - nums = [0,1,0,3,2,3]
        Output - 4
        
    Example 3 -
        Input - nums = [7,7,7,7,7,7,7]
        Output - 1
*/

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {
    public int LCS(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int max = 0;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int arr[] = new int[set.size()]; // Sorted Unique Elements
        int i = 0; 
        for(int num : set){
            arr[i] = num;
            i++;
        }
        Arrays.sort(arr);
        return LCS(nums, arr);
    }
}