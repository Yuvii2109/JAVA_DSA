/*
    Given an array of strings strs, group the anagrams together. You can 
    return the answer in any order.

    Example 1 -
        Input - strs = ["eat","tea","tan","ate","nat","bat"]
        Output - [["bat"],["nat","tan"],["ate","eat","tea"]]
        Explanation - There is no string in strs that can be rearranged to 
        form "bat". The strings "nat" and "tan" are anagrams as they can 
        be rearranged to form each other. The strings "ate", "eat", and 
        "tea" are anagrams as they can be rearranged to form each other.

    Example 2 -
        Input - strs = [""]
        Output - [[""]]

    Example 3 -
        Input - strs = ["a"]
        Output - [["a"]]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder strB = new StringBuilder();
            for(int i = 0; i < 26; i++){
                strB.append(count[i]).append("#"); // With Unique Separator
            }
            String s = strB.toString();
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}

/*
    Processing "eat" - Initialize count[26] = {0,0,0,...,0}
        Update frequency counts -
            'e' → count[4]++ → {0,0,0,0,1,...}
            'a' → count[0]++ → {1,0,0,0,1,...}
            't' → count[19]++ → {1,0,0,0,1,...,1,...}
        Convert to key - 
        "1#0#0#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0#"

    Insert into map - map.put("1#0#0#0#1#0...1#0#0#", ["eat"])

    Processing "tea" - Frequency count same as "eat".
        Key is identical to "eat", so "tea" is added to the same list -
        map.get("1#0#0#0#1#0...1#0#0#").add("tea");

    Processing "tan" - Character count -
        't' → count[19]++, 'a' → count[0]++, 'n' → count[13]++
        Key - "1#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#1#0#0#0#0#0#0#"
        New key, so insert into map -
        map.put("1#0#0#0#0#0...1#0#0#", ["tan"])

    Processing "ate" - Frequency count same as "eat" and "tea".
        Key is identical, so "ate" is added -
        map.get("1#0#0#0#1#0...1#0#0#").add("ate");

    Processing "nat" - Frequency count same as "tan".
        Key is identical, so "nat" is added -
        map.get("1#0#0#0#0#0...1#0#0#").add("nat");

    Processing "bat" - Character count -
        'b' → count[1]++, 'a' → count[0]++, 't' → count[19]++
        Key - "1#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0#"
        New key, so insert into map -
        map.put("1#1#0#0#0#0...1#0#0#", ["bat"])

    Step 3 - Construct Output
        Convert map.values() to a list -
        [ ["eat", "tea", "ate"], ["tan", "nat"], ["bat"] ]
*/