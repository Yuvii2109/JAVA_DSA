// Variation of Longest Common Subsequence
// Input - arr[] = {50, 3, 10, 7, 40, 80}
// Output - 4 ({3, 10, 40, 80} or {3, 7, 40, 80})

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {
    public static int longestCommonSubsequence(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
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
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        // Time complexity - O(n*m)
    }
    public static int longestIncreasingSubsequence(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        int arr2[] = new int[set.size()]; // Sorted unique elements
        int i = 0; 
        for(int num : set){
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2); // Ascending
        return longestCommonSubsequence(arr1, arr2);
    }
    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println("Length of longest increasing subsequence - " + longestIncreasingSubsequence(arr));
    }
}