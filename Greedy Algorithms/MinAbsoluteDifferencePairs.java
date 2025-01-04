// Given 2 arrays A and B of equal length n. Pair each element of array A
// to an element in array B, such that the sum of absolute differences of 
// paired elements is minimized.
// Example - 
// ArrayA = [1, 2, 3]
// ArrayB = [2, 1, 3]
// Output - 0 -> 1 paired with 1, 2 paired with 2, 3 paired with 3 

import java.util.*;

public class MinAbsoluteDifferencePairs {
    public static void main(String[] args) {
        int[] arrayA = {4, 1, 8, 7};
        int[] arrayB = {2, 3, 6, 5};
        Arrays.sort(arrayA); // The difference between the corresponding elements of
        Arrays.sort(arrayB); // a sorted array give the minimum absolute difference
        int minDifference = 0;
        for (int i = 0; i < arrayA.length; i++) {
            minDifference += Math.abs(arrayA[i] - arrayB[i]);
        }
        System.out.println("Minimum Absolute Difference - " + minDifference);
    }
}