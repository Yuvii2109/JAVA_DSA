// Find the longest string in words such that every prefix of it is 
// also in words. Example - 
// Input - words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
// Output - "apple"

public class LongestWordWithAllPrefixes {
    
    public static class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
    }
    
    public static Node root = new Node();
    public static String longestWord = "";
    
    // Function to insert a word into the trie
    public static void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    // Function to find the longest word with all prefixes present in the trie
    public static void findLongestWord(Node node, StringBuilder currentWord) {
        // The function is a recursive depth-first traversal (DFS) over the Trie. This ensures that only the longest valid word with all prefixes is stored. The function explores all possible words in lexicographical order (since 'a' + i starts from 'a').
        if (node == null) return;
        
        // Check if the currentWord formed so far is longer than the longestWord found
        if (currentWord.length() > longestWord.length()) {
            longestWord = currentWord.toString();
        }
        
        // Traverse all children of the current node
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].isEndOfWord) {
                currentWord.append((char) ('a' + i));
                findLongestWord(node.children[i], currentWord);
                currentWord.deleteCharAt(currentWord.length() - 1); // backtrack
            }
            // The isEndOfWord condition ensures we only extend the word if all its prefixes are present. The backtracking mechanism allows checking multiple word possibilities without affecting prior choices.
        }
    }
    
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        
        // Insert all words into the trie
        for (String word : words) {
            insert(word);
        }
        
        // Find the longest word with all prefixes present in the trie
        findLongestWord(root, new StringBuilder());
        
        // Print the longest word found
        System.out.println("Longest word with all prefixes - " + longestWord);
    }
}

/*
    Example Walkthrough -

    Given input - words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]

    Step 1 - Trie Construction
        "a" → root → 'a' (endOfWord=true)
        "banana" → root → 'b' → 'a' → 'n' → 'a' → 'n' → 'a' (endOfWord=true)
        "ap" → root → 'a' → 'p' (endOfWord=true)
        "app" → root → 'a' → 'p' → 'p' (endOfWord=true)
        "appl" → root → 'a' → 'p' → 'p' → 'l' (endOfWord=true)
        "apple" → root → 'a' → 'p' → 'p' → 'l' → 'e' (endOfWord=true)
        "apply" → root → 'a' → 'p' → 'p' → 'l' → 'y' (endOfWord=true)

    Step 2 - Finding the Longest Word
        "banana" is invalid because "b" is not in words.
        "apply" and "apple" both are valid because so lexicographical order breaks the tie.

    Final Output - Longest word with all prefixes - apple
*/