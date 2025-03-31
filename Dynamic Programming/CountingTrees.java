// Find number of all possible BSTs with given n nodes.
// Input - n = 3(10, 20, 30)
// Output - 5
// Input - n = 4(10, 20, 30, 40)
// Output - 14

public class CountingTrees {
    public static int countBSTs(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j]; // Left-Subtree nodes kitne tareeke se arrange ho sakte hain
                int right = dp[i - j - 1]; // Right-Subtree nodes kitne tareeke se arrange ho sakte hain
                dp[i] += left * right;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        System.out.println("Maximum number of BSTs possible for n = " + n + " -> " + countBSTs(n));
        System.out.println("Maximum number of BSTs possible for m = " + m + " -> " + countBSTs(m));
    }
}