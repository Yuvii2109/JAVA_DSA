// Find shortest unique prefix for every word in a given list. Assume no
// word is prefix of another.
// Sample Input - {"zebra", "dog", "duck", "dove"};
// Sample Output - {"z", "dog", "du", "dov"};

public class PrefixProblem {
    public static class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        int frequency; // Frequency counter to track occurrences of the prefix

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            frequency = 1;
        }
    }
    public static Node root = new Node();
    public static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';  
            // Calculate index for current character
            if (current.children[index] == null) {
                current.children[index] = new Node();  
                // Create new node if not present
            } else {
                current.children[index].frequency++;   
                // Increment frequency if node exists
            }
            current = current.children[index];         
            // Move to the next node
        }
    }    
    public static void findPrefix(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.frequency == 1) {
            System.out.print(ans + " ");  
            // Print the prefix when frequency is 1
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            // If frequency is 1, it means the prefix represented by 
            // ans is unique for a word, so it prints ans.
            // It recursively explores all child nodes to find all 
            // unique prefixes.
            if (root.children[i] != null) {
                // This checks if the current node has a child node 
                // corresponding to the character represented by index i.
                // root.children[i] is null if no word in the trie 
                // continues with the character at that index.
                findPrefix(root.children[i], ans + (char) ('a' + i)); 
                // If root.children[i] is not null, it means there is a 
                // word in the trie that includes the character at index i.
                // The findPrefix method is called recursively -
                // root.children[i] - The recursive call moves to the 
                // child node corresponding to the character at index i.
                // ans + (char) ('a' + i) -
                // (char) ('a' + i) converts the index i back to the 
                // corresponding character. For example -
                // If i = 0, 'a' + 0 gives 'a'.
                // If i = 1, 'a' + 1 gives 'b', and so on.
                // ans is a string representing the prefix constructed 
                // so far. The current character (char) ('a' + i) is 
                // appended to ans to extend the prefix as the traversal 
                // progresses deeper into the trie.
            }
        }
    }    
    public static void main(String[] args) {
        String[] words = {"zebra", "dog", "duck", "dove"};
        for(String word : words){
            insert(word);
        }
        root.frequency = -1; 
        // Edge Case Handling - Setting root.frequency = -1 ensures that 
        // the root node itself is not considered for output, focusing 
        // only on actual prefixes stored within the trie.
        findPrefix(root, "");
    }
}