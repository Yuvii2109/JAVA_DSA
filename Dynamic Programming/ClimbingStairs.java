// Count ways to reach the nth stair. The person can climb either 1 or 2 stairs at a time.

// Okay so observe...
// Ways to climb 1 stair - 1(1)
// Ways to climb 2 stairs - 2(11, 2)
// Ways to climb 3 stairs - 3(111, 21, 12)
// Ways to climb 4 stairs - 5(1111, 211, 121, 22, 112) ab yahan hua kya agar hum dhyaan den toh... ways to climb 3 stairs - (111, 21, 12), isme humne bas 1 or 2 add kra => (1111, 211, 121) and ways to climb 2 stairs - (11, 2), isme humne again 2 add kra => (112, 22)
// So basically, ways to climb n stairs = ways to climb (n-1) stairs + ways to climb (n-2) stairs. This is a classic example of a dynamic programming problem. We can solve this problem using recursion, but it will be inefficient because we will be repeating the same subproblems multiple times. We can solve this problem using dynamic programming, where we store the results of subproblems in a table so that we don't have to repeat the same subproblems multiple times.
// Main Formula - ways(n) = ways(n-1) + ways(n-2)

// Ab question ki sirf yehi nahi balki or bhi bohot si variations ho sakti hain... For Example - we may be allowed to climb 1, 2, 3 stairs rather than just 1 and 2 stairs, for such case - 
// ways(n) = ways(n-1) + ways(n-2) + ways(n-3) and similarly for others...

import java.util.Arrays;

public class ClimbingStairs {
    public static int countWaysGandaCheeChee(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return countWaysGandaCheeChee(n-1) + countWaysGandaCheeChee(n-2);
        // Time Complexity - O(2^n)
    }
    public static int countWaysMemoization(int n, int[] ways){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = countWaysMemoization(n-1, ways) + countWaysMemoization(n-2, ways);
        return ways[n];
        // Time Complexity - O(n)
    }
    public static int countWaysTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
        // Time Complexity - O(n)
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int ways[] = new int[n+1]; // n+1 ka karan - [0, 1, 2, 3, 4]
        Arrays.fill(ways, -1);
        System.out.println("Number of ways to climb till " + n + "th stair - " + countWaysMemoization(n, ways)); // Output - 5
        System.out.println("Number of ways to climb till " + m + "th stair - " + countWaysTabulation(5)); // Output - 8
    }
}