// Given an array of integers. Find the Inversion Count in the array. (HARD)
// Inversion Count: For an array, inversion count indicates how far(or close) the array is from
// being sorted. If the array is already sorted then the inversion count is 0. If an array is
// sorted in the reverse order then the inversion count is the maximum.
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// Sample Input 1: N = 5, arr[ ] = {2, 4, 1, 3, 5}
// Sample Output 1: 3, because it has 3 inversions -> (2, 1), (4, 1), (4, 3).
// Sample Input 2 : N = 5, arr[ ] = {2, 3, 4, 5, 6}
// Sample Output 2 : 0, because the array is already sorted
// Sample Input 3 : N = 3, arr[] = {5, 5, 5}
// Sample Output 3 : 0, because all the elements of the array are the same & already in a sorted
// manner.

public class InversionCount {
    // Approach 1 - Brute Force Approach
    //     Idea - Traverse through the array, and for every index, find the 
    //     number of smaller elements on its right side of the array. This 
    //     can be done using a nested loop. Sum up the counts for all
    //     indexes in the array and print the sum.
    //         ● Traverse through the array from start to end
    //         ● For every element, find the count of elements smaller than
    //         the current number upto that index using another loop.
    //         ● Sum up the count of inversion for every index.
    //         ● Print the count of inversions.
    //     Time complexity - O(n^2)
    public static int inversionCountBruteForce(int[] arr) {
        int n = arr.length;
        int inversionCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 4, 5};
        System.out.println("Inversion Count - " + inversionCountBruteForce(arr));
    }
}