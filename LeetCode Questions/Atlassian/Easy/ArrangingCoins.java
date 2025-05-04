/*
    You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete. Given the integer n, return the number of complete rows of the staircase you will build. 

    Example 1 -
        Input - n = 5
        Output - 2
        Explanation - Because the 3rd row is incomplete, we return 2.

    Example 2 -
        Input - n = 8
        Output - 3
        Explanation - Because the 4th row is incomplete, we return 3.
*/

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        // We want the largest k such that k*(k+1)/2 <= n
        // Solve k^2 + k - 2n <= 0 -> k = (−1 + sqrt(1 + 8n)) / 2
        // Taking the floor of that gives the maximum integer k
        long k = n; // Preventing overflow
        return (int)((Math.sqrt(8*k + 1) - 1) / 2);
    }
}