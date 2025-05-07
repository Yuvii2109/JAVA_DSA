/*
    Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "". 

    Example 1 - 
        Input - strs = ["flower","flow","flight"]
        Output - "fl"

    Example 2 -
        Input - strs = ["dog","racecar","car"]
        Output - ""
        Explanation - There is no common prefix among the input strings.
*/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            // While the current string does not start with the prefix, shorten the prefix
            while(strs[i].indexOf(prefix) != 0){
                // Chop off the last character
                prefix = prefix.substring(0, prefix.length() - 1);
                // If we've shrunk down to empty, there is no common prefix
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}