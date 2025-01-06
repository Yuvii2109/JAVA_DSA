// We have two variables L and R, indicating a range of integers from 
// L to R inclusive, and a number K, the task is to find Kth largest 
// odd number. If K > number of odd numbers in the range
// L to R then return 0.
// Sample Input 1 - L = -3, R = 3, K = 1
// Sample Output 1 - 3

public class KthLargestOddNoInRange {
    // Yaara greedy di lod hi ni haigi aide vich
    public static int findKthLargestOdd(int L, int R, int K) {
        // Calculate the number of odd numbers in the range
        int oddCount = (R - L) / 2 + 1;

        // Adjust oddCount if L and R are not both odd
        if (L % 2 == 0 && R % 2 == 0) {
            oddCount--;
        }

        // If K is greater than the number of odd numbers, return 0
        if (K > oddCount) {
            return 0;
        }

        // Find the largest odd number in the range
        int largestOdd = (R % 2 == 0) ? R - 1 : R;

        // Calculate the Kth largest odd number
        return largestOdd - 2 * (K - 1);
    } 
    public static void main(String[] args) {
        int L = 0, R = 100, K = 5;
        System.out.println("Kth largest odd number - " + findKthLargestOdd(L, R, K));
    }
}

// Negative numbers main bhi even odd same tareeke se consider hote hain
// And zero is considered as an even number

// Time complexity - O(1)