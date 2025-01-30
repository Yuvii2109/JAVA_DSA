// Given an array of strings strs, group the anagrams together. You 
// can return the answer in any order. An Anagram is a word or phrase 
// formed by rearranging the letters of a different word or phrase, 
// typically using all the original letters exactly once.
// Sample Input 1 - strs = ["eat","tea","tan","ate","nat","bat"]
// Sample Output 1 - [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
// Sample Input 2 - strs = [""]
// Sample Output 2 - [[""]]
// Sample Input 3 - strs = ["a"]
// Sample Output 3 - [["a"]]

import java.util.*;

public class GroupAnagramsTogether {
    
    // Trie Node class
    static class TrieNode {
        Map<String, TrieNode> children;
        List<String> anagrams;

        TrieNode() {
            children = new HashMap<>();
            anagrams = new ArrayList<>();
        }
    }
    // Each node in the Trie represents a unique character frequency pattern. children (Map<String, TrieNode>) → Stores different frequency patterns as keys. anagrams (List<String>) → Stores all words that belong to the same frequency pattern (i.e., anagram group).

    // Root of Trie
    static TrieNode root = new TrieNode();

    // Function to generate a frequency key for a given word
    private static String getFrequencyKey(String word) {
        int[] freq = new int[26]; // Frequency of each letter
        
        // Count frequencies
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // Convert frequency array into a string key
        StringBuilder key = new StringBuilder();
        for (int count : freq) {
            key.append(count).append("#"); // Append frequency with a separator
        }
        
        return key.toString();
    }
    // Instead of sorting (which takes O(N log N) time), we use character frequency counting, which takes O(N). Example - 
    // "eat", "tea", and "ate" all have - {'a': 1, 'e': 1, 't': 1}
    // This is converted into a unique key string - "1#1#1#0#0#...#"
    // Since all anagrams have the same frequency key, we can group them efficiently.

    // Function to insert a word into the Trie based on its frequency key
    private static void insert(String word) {
        String key = getFrequencyKey(word); // Get unique key for anagram group
        TrieNode current = root;
        
        // If key does not exist, create a new node
        current.children.putIfAbsent(key, new TrieNode());
        
        // Move to the corresponding Trie node
        current = current.children.get(key);
        
        // Add word to the anagram list
        current.anagrams.add(word);
    }
    // Inserting "eat", "tea", and "ate" → They share the same frequency key, so they get stored in the same Trie node.

    // Function to retrieve all anagram groups from Trie
    private static List<List<String>> getAnagramGroups() {
        List<List<String>> result = new ArrayList<>();
        
        // Traverse the Trie to collect anagram groups
        for (TrieNode node : root.children.values()) {
            result.add(node.anagrams);
        }
        
        return result;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        root = new TrieNode(); // Reset the Trie
        
        // Insert all words into the Trie
        for (String word : strs) {
            insert(word);
        }
        
        // Retrieve and return anagram groups
        return getAnagramGroups();
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
    }
}