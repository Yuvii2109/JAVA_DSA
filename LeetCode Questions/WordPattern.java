/*
    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically -

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.   

    Example 1 -
        Input - pattern = "abba", s = "dog cat cat dog"
        Output - true
        Explanation - The bijection can be established as -
            'a' maps to "dog".
            'b' maps to "cat".

    Example 2 -
        Input - pattern = "abba", s = "dog cat cat fish"
        Output - false

    Example 3 -
        Input - pattern = "aaaa", s = "dog cat cat dog"
        Output - false
*/

import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Splitting on the basis of spaces 
        String[] words = s.split(" ");
        // If the counts don't match, it can't be a full bijection
        if (words.length != pattern.length()) {
            return false;
        }
        // map1 - character in pattern → word in s
        Map<Character, String> charToWord = new HashMap<>();
        // map2 - word in s → character in pattern
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String w = words[i];
            // Case 1 - we have seen this pattern character before
            if(charToWord.containsKey(c)){
                // If the previously mapped word is different → mismatch
                if(!charToWord.get(c).equals(w)){
                    return false;
                }
            }else{
                // Case 2 - new pattern character
                // But if the word is already mapped to some other character → mismatch
                if (wordToChar.containsKey(w)) {
                    return false;
                }
                // Establish the new mapping in both directions
                charToWord.put(c, w);
                wordToChar.put(w, c);
            }
        }
        // All checks passed → s follows the pattern
        return true;
    }
}