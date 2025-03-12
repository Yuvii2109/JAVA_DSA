public class ClimbingStairs {
    public int climbStairs(int n) {
        /*
            int dp[] = new int[n+1]; // Create an array to store solutions for subproblems up to n
            dp[0] = 1; // There's 1 way to climb 0 stairs (doing nothing)
            dp[1] = 1; // There's 1 way to climb 1 stair (1 step)
            for(int i = 2; i <= n; i++){
                dp[i] = dp[i-1] + dp[i-2]; // Number of ways to reach step i is sum of ways to reach (i-1) and (i-2)
            }
            return dp[n];
        */
        // Complexities - Time - O(n), Space - O(n)
        if(n == 1) return 1;
        int prev2 = 1;
        int prev1 = 2;
        for(int i = 3; i <= n; i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1; // prev1 is returned as current is a temporary variable inside the loop and can't be accessed outside the for loop.
        // Complexity Analysis - Time - O(n), Space - O(1)
    }
}