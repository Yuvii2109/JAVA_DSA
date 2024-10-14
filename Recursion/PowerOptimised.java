public class PowerOptimised {
    public static int optiPow(int n, int x) {
        // Base case - when x is 0, any number raised to 0 is 1
        if (x == 0) {
            return 1;
        }
        
        // Recursive case -
        // Compute half power square using recursion
        int halfPowerSq = optiPow(n, x/2) * optiPow(n, x/2);
        
        // If x is odd, multiply halfPowerSq by n to get the final result
        if (x % 2 != 0) {
            halfPowerSq = n * halfPowerSq;
        }
        
        // Return the computed power
        return halfPowerSq;
    }
    public static void main(String[] args) {
        System.out.println("\n" + optiPow(2, 10) + "\n");
    }
}

// Let's say you call optiPow(2, 5) ->

// First call - optiPow(2, 5) computes optiPow(2, 2) * optiPow(2, 2) 
// and then multiplies by 2 (since 5 is odd).
// Second call (inside the first call) - optiPow(2, 2) computes 
// optiPow(2, 1) * optiPow(2, 1) and then multiplies by 2 (since 2 is even).
// Third call (inside the second call) - optiPow(2, 1) returns 2 (base case).
// Combining all, optiPow(2, 5) would evaluate to 2^5 = 32.