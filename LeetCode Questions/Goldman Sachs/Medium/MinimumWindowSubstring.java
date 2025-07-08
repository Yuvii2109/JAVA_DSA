/*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    Example 1 -
        Input - s = "ADOBECODEBANC", t = "ABC"
        Output - "BANC"
        Explanation - The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2 -
        Input - s = "a", t = "a"
        Output - "a"
        Explanation - The entire string s is the minimum window.

    Example 3 -
        Input - s = "a", t = "aa"
        Output - ""
        Explanation - Both 'a's from t must be included in the window. Since the largest window of s only has one 'a', return empty string.
*/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n){
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int required = need.size(); // Number of distinct chars we must match
        int formed = 0; // How many distinct chars in current window meet required freq

        Map<Character, Integer> window = new HashMap<>();
        // (window length, left, right) for best answer
        int[] ans = {Integer.MAX_VALUE, 0, 0};
        int l = 0, r = 0;
        while(r < s.length()){
            // Expand the window by including s[r]
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // If this char's freq now matches exactly what's needed, we form one more
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Contract the window while it's "desirable" (we've matched all required chars)
            while (l <= r && formed == required) {
                c = s.charAt(l);
                
                // Update best answer if this window is smaller
                if (r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                // Remove s[l] from window
                window.put(c, window.get(c) - 1);
                if (need.containsKey(c) && window.get(c).intValue() < need.get(c).intValue()) {
                    formed--;
                }
                
                l++;  // move left pointer to contract
            }
            
            // Move right pointer to expand
            r++;
        }
        
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}