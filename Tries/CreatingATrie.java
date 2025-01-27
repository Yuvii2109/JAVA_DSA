// A trie (pronounced "try") is a specialized tree-based data structure 
// that is used to store a dynamic set of strings, typically designed 
// for fast retrieval of strings and efficient prefix searching. It 
// stands for "retrieval" or "prefix tree."

// It is a K-ary data structure

// Let words[] = {"the", "a", "there", "their", "any", "thee"}
// The trie will be -
//                .
//               / \
//              t   a
//             /     \
//            h       n
//           /         \
//          e           y
//        / | \
//       r  e  i
//      /       \  
//     e         r

public class CreatingATrie {
    // Node class representing each node in the Trie
    public static class Node {
        Node[] children = new Node[26]; // Array to store children nodes for each letter ('a' to 'z')
        boolean isEndOfWord = false; // Flag to mark the end of a word
        
        // Constructor to initialize children array
        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null; // Initialize each child node as null
            }
        }
    }
    
    // Root of the Trie
    public static Node root = new Node();

    // Method to insert a word into the Trie
    public static void insert(String word) {
        Node current = root; // Start from the root
        
        // Traverse each character of the word
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert character to index (0-25)
            
            // If the current character's node doesn't exist, create a new node
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            
            // Move to the next node
            current = current.children[index];
        }
        
        // Mark the end of the word
        current.isEndOfWord = true;
    }

    // Method to search for a word in the Trie
    public static boolean search(String key) {
        Node current = root; // Start from the root
        
        // Traverse each character of the key
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a'; // Convert character to index (0-25)
            
            // If the current character's node doesn't exist, the word doesn't exist in the Trie
            if (current.children[index] == null) {
                return false;
            }
            
            // Move to the next node
            current = current.children[index];
        }
        
        // Check if the end of the word is reached
        return current.isEndOfWord;
    }

    // Main method to demonstrate Trie operations
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        
        // Insert each word into the Trie
        for (String word : words) {
            insert(word);
        }
        
        // Perform searches and print results
        System.out.println(search("the"));   // true
        System.out.println(search("thee"));  // true
        System.out.println(search("th"));    // false
    }
}