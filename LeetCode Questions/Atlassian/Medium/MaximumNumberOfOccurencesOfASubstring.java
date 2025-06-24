/*
    Given a string s, return the maximum number of occurrences of any substring under the following rules:

    The number of unique characters in the substring must be less than or equal to maxLetters.
    The substring size must be between minSize and maxSize inclusive.
    
    Example 1 -
        Input - s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
        Output - 2
        Explanation - Substring "aab" has 2 occurrences in the original string. It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).

    Example 2 -
        Input - s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
        Output - 2
        Explanation - Substring "aaa" occur 2 times in the string. It can overlap.
*/

import java.util.Map;

public class MaximumNumberOfOccurencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        if(n < minSize) return 0;
        Map<String, Integer> freq = new HashMap<>();
        int[] count = new int[26];
        int unique = 0; // number of distinct letters in window
        char[] arr = s.toCharArray();
        for(int i = 0; i < minSize; i++){
            int index = arr[i] - 'a';
            if(count[index]++ == 0) unique++;
        }
        // If it meets the letter‐limit constraint, record it
        if(unique <= maxLetters){
            String sub = s.substring(0, minSize);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
        }
        // Slide the window across the string
        for(int i = minSize; i < n; i++){
            // Remove the char going out
            int out = arr[i - minSize] - 'a';
            if(--count[out] == 0) unique--;

            // Add the new char coming in
            int in = arr[i] - 'a';
            if(count[in]++ == 0) unique++;

            // If valid, record the substring ending at i
            if(unique <= maxLetters){
                String sub = s.substring(i - minSize + 1, i + 1);
                freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            }
        }

        // Now find the maximum occurrence count
        int ans = 0;
        for(int c : freq.values()){
            ans = Math.max(ans, c);
        }
        return ans;
    }
}