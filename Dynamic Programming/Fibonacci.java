public class Fibonacci {
    // Baar Baar Recursion Tree Create krna bewakoofi hai toh hum laaye hain ek array to store the values of the series to prevent the excess time complexity -
    public static int fibMemoization(int n , int f[]){
        if(n==0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            // Which mean f[n] is already calculated -
            return f[n];
        }
        f[n] = fibMemoization(n-1, f) + fibMemoization(n-2, f);
        return f[n];
    }
    public static void fibTabulation(int n){
        int dp[] = new int[n+1]; // n+1 is kyuki hum shuru kr rhe hain 0 se or hume nikalni hai nth value
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print("Fibonacci Series using Tabulation is - ");
        for(int i = 0 ; i <= n ; i++){
            System.out.print(dp[i] + " ");
        }
    }
    public static void main(String[] args) {
        int n = 5; 
        int f[] = new int[n+1];
        System.out.println(fibMemoization(n, f));
        fibTabulation(n);
    }
}

// Ab iski Time Complexity Linear hai O(n) varna exponential hoti
// Basically yahan hua kya hai ?
// Memoization - Humne extra calculations prevent kri and important or required values ko store krdia ab hume unn values ko dobara calculate krne ki zaroort nahi hai... isse fayda yeh ho rha hai ki humare program ki execution ka time ghat rha hai because it is no longer devoting time to the proceses which have already been determined... Yeh ek example hai Dynamic Programming ka...
// Tabulation – Isme humne bas jo jo values nikali unhe table ki form main store kara diya toh again hume recalculate nahi krna pada and again humari time complexity turns out to be linear