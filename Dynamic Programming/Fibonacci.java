public class Fibonacci {
    // Baar Baar Recursion Tree Create krna bewakoofi hai toh hum laaye hain ek array to store the values of the series to prevent the excess time complexity -
    public static int fib(int n , int f[]){
        if(n==0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            // Which mean f[n] is already calculated -
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }
    public static void main(String[] args) {
        int n = 5; 
        int f[] = new int[n+1];
        System.out.println(fib(n, f));
    }
}

// Ab iski Time Complexity Linear hai O(n) varna exponential hoti
// Basically yahan hua kya hai ?
// Memoization - Humne extra calculations prevent kri and important or required values ko store krdia ab hume unn values ko dobara calculate krne ki zaroort nahi hai... isse fayda yeh ho rha hai ki humare program ki execution ka time ghat rha hai because it is no longer devoting time to the proceses which have already been determined... Yeh ek example hai Dynamic Programming ka...