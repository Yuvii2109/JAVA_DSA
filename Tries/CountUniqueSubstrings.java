// Given a string of length n of lowercase alphabet characters, we need
// to count total number of distinct substrings of this string
// Input - "ababa"
// Output - 10 {"a", "b", "ab", "ba", "aba", "bab", "abab", "baba", "ababa", ""}
// Unique substring - saare suffix nikal kar unke unique prefix nikalne se 
// answer mil jayega rey...

public class CountUniqueSubstrings {
    public static class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node current = root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    public static int countNodes(Node root){
        // The countNodes method recursively counts all nodes in the Trie -
        // If root is null, it returns 0.
        // It initializes count to 0.
        // It iterates through each index of root's children array 
        // (from 'a' to 'z'). If a child node (root.children[i]) exists, 
        // it recursively counts nodes starting from that child.
        // It adds 1 to count for the current node and returns the total 
        // count of nodes in the subtree rooted at root.

        if(root == null) return 0; // If node == null, returns 0

        int count = 0; // Initializes a counter to store the number of nodes in the subtree rooted at the current node.

        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]); // If a child node exists at index i, recursively call countNodes(root.children[i]). Adds the number of nodes in the child subtree to count.
            }
        }

        return (count + 1); // Returns the total count of nodes in the subtree rooted at root, including the current node.
    }
    public static void main(String args[]){
        String str = "ababa";
        for(int i = 0; i < str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        /*
         * Suffixes - {"ababa", "baba", "aba", "ba", "a"}
         *  
         *            .
         *           / \
         *          b   a*
         *         /     \
         *        a*      b
         *       /         \
         *      b           a*
         *     /             \
         *    a*              b
         *                     \
         *                      a*
         */
        System.out.println("Total number of distinct substrings of '" + str + "' - " + countNodes(root));
    }
}

/*
    Nodes Breakdown -
        (root) - 1 node
        'b' (directly under root) → 1 node
        'ba' → 1 node
        'bab' → 1 node
        'baba' → 1 node (leaf)
        'a' (directly under root) → 1 node (leaf)
        'ab' → 1 node
        'aba' → 1 node (leaf)
        'abab' → 1 node
        'ababa' → 1 node (leaf)

    Total Node Count -

        Adding all these nodes together -
            1 (root) + 1 (b) + 1 (ba) + 1 (bab) + 1 (baba) + 1 (a) + 1 (ab) + 1 (aba) + 1 (abab) + 1 (ababa) = 10

    So, the total number of distinct substrings (count of nodes in the Trie) is 10.
*/