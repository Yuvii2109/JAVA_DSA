/*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0]. Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where - 
        0 <= j <= nums[i] and
        i + j < n
    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

    Example 1 - 
        Input - nums = [2,3,1,1,4]
        Output - 2
        Explanation - The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2 -
        Input - nums = [2,3,0,1,4]
        Output - 2
*/

import java.util.Arrays;

public class MinimumArrayJumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] jumps = new int[n];
        Arrays.fill(jumps, -1);
        jumps[n-1] = 0; // The last index requires 0 jumps to reach itself. This acts as the base case for our DP approach.

        // Looping backwards
        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i]; // For each index i, we know arr[i] tells us how far we can jump forward. We store that number in steps.
            int ans = Integer.MAX_VALUE; // We use ans to find the best (minimum) jump count from index i to the end. It is initialized to a very high value (Integer.MAX_VALUE) to later capture a smaller feasible jump count.

            for (int j = i + 1; j <= i + steps && j < n; j++){
                if(jumps[j] != -1){
                    ans = Math.min(ans, jumps[j] + 1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                jumps[i] = ans;
            }
        }
        // By iterating backwards, we can determine, for each position, the minimum jumps required to reach the end. This is possible because by the time we process an index, we’ve already solved the problem for all indices ahead of it. The idea is to “simulate” a jump from index i to each possible future index j that can be reached directly. If reaching j is possible, then it might be optimal to choose that jump if jumps[j] + 1 (adding the jump from i to j) is lower than our current best count.

        System.out.print("The DP Table so formed - [ ");
        for(int i = 0; i < n; i++){
            System.out.print(jumps[i] + " ");
        }
        System.out.print("]");
        return jumps[0];
    }
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println("\nMinimum Jumps required - " + minJumps(nums));
    }
}

/*
    Initialization - n = 5
        jumps initialized as - [ -1, -1, -1, -1, 0 ]

    Iteration (i = 3) -
        arr[3] = 1 → so you can jump from index 3 to only index 4.
        For j = 4 -
        jumps[4] = 0, so possible jumps count = 0 + 1 = 1.
        Update - jumps[3] = 1
        DP table now - [ -1, -1, -1, 1, 0 ]

    Iteration (i = 2) - 
        arr[2] = 1 → from index 2, you can only jump to index 3.
        For j = 3 -
        jumps[3] = 1, so possible jumps count = 1 + 1 = 2.
        Update - jumps[2] = 2
        DP table now - [ -1, -1, 2, 1, 0 ]

    Iteration (i = 1) -
        arr[1] = 3 → from index 1, you can jump to indices 2, 3, or 4.
        For j = 2 -
        jumps[2] = 2 gives potential jumps = 2 + 1 = 3.
        For j = 3 -
        jumps[3] = 1 gives potential jumps = 1 + 1 = 2 (better).
        For j = 4 -
        jumps[4] = 0 gives potential jumps = 0 + 1 = 1 (even better).
        Update - jumps[1] = 1
        DP table now - [ -1, 1, 2, 1, 0 ]

    Iteration (i = 0) -
        arr[0] = 2 → from index 0, you can jump to indices 1 or 2.
        For j = 1 -
        jumps[1] = 1 gives potential jumps = 1 + 1 = 2.
        For j = 2 -
        jumps[2] = 2 gives potential jumps = 2 + 1 = 3.
        Choose the minimum - jumps[0] = 2
        Final DP table - [ 2, 1, 2, 1, 0 ]
        
    Output - The program prints the DP table and returns 2, indicating that 2 jumps are needed to reach the end.
*/