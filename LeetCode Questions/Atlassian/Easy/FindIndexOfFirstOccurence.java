/*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 

    Example 1 - 
        Input - haystack = "sadbutsad", needle = "sad"
        Output - 0
        Explanation - "sad" occurs at index 0 and 6.
        The first occurrence is at index 0, so we return 0.

    Example 2 -
        Input - haystack = "leetcode", needle = "leeto"
        Output - -1
        Explanation - "leeto" did not occur in "leetcode", so we return -1.
*/

public class FindIndexOfFirstOccurence {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        int n = haystack.length(), m = needle.length();
        if(n < m){
            return -1;
        }
        for(int i = 0; i <= n-m; i++){
            int j = 0;
            while(j < m && haystack.charAt(i + j) == needle.charAt(j)){
                j++;
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }
}