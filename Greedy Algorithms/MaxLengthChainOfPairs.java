// You are given n pairs of numbers. In every pair, the first number is always
// less than the second number. A pair (c, d) can come after pair (a, b) if 
// b < c. Find the longest chain that can be formed from a given set of pairs.
// Pairs - (5, 24), (39, 60), (5, 28), (27, 40), (50, 90)
// Output - 3
// Tedhi bhasha main activity selection hi hai yaara

import java.util.*;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        // This sorts the array pairs in ascending order based on the 
        // second number (b) of each pair. Sorting ensures that when 
        // iterating over the pairs, we always consider the pair with 
        // the smallest possible "end time" next. 
        int chainLength = 1;
        int chainEnd = pairs[0][1]; // Last selected pair's second number
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }
        // Loop through the sorted pairs starting from the second pair (i = 1).
        // For each pair (c,d), check if the first number c of the current 
        // pair is greater than the chainEnd (the second number of the last 
        // selected pair). If  c > chainEnd:
        // Include the current pair in the chain.
        // Increment the chain length.
        // Update chainEnd to the second number (d) of the current pair.
        // This ensures that the selected pairs form a valid chain.
        System.out.println("Maximum length of chain - " + chainLength);
    }    
}

// Time complexity - (nlogn)