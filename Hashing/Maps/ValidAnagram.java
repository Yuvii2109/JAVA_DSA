// Given two strings s and t, return true if t is an anagram of s, and
// false otherwise. An anagram is a word or phrase formed by rearranging
// the letters of a different word or phrase, typically using all the 
// original letters exactly once.
// Input - s = "heart", t = "earth" -> Output - true.
// Input - s = "listen", t = "silent" -> Output - true.
// Input - s = "hello", t = "world" -> Output - false.

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        // Create a HashMap to store character frequencies of string s
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Populate the HashMap with frequencies of characters in string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If the character already exists in the map, increment its count
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else { // Otherwise, add it to the map with count 1
                map.put(ch, 1);
            }
        }
        
        // Iterate through string t to check if it is an anagram of s
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            // If the character exists in the map, decrement its count
            if (map.containsKey(ch)) {
                // If count becomes 0, remove the entry from the map
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
            } else { // If the character does not exist in the map, return false
                return false;
            }
        }
        
        // If the map is empty after iterating through string t, they are anagrams
        return map.isEmpty();
    }
    
    public static void main(String[] args) {
        if(isAnagram("heart", "earth")){
            System.out.println("It is an anagram");
        } else {
            System.out.println("It is not an anagram");
        }
    }
}