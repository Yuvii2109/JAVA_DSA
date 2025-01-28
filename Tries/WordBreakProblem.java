// Given an input string and a dictionary of words, find out if the input
// string can be broken into a space separated sequence of dictionary words
// Example -
// Input - {"i", "like", "sam", "samsung", "mobile", "ice"}, key - "ilikesamsung"
// Output - True

public class WordBreakProblem {
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
    public static boolean search(String key){
        Node current = root;
        for(int i=0; i<key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    public static boolean wordBreak(String str) {
        if(str.length() == 0){
            return true;
        }
        for(int i=1; i<str.length(); i++){
            if(search(str.substring(0, i)) && wordBreak(str.substring(i))){
                return true;
            }
        }
        return search(str);
    }
    // wordBreak(String str) - This method implements a recursive 
    // approach to determine if a given string (str) can be segmented 
    // into space-separated words from the dictionary.
    // Base case - If str is empty (str.length() == 0), it returns true.
    // Recursive case - It tries all possible partitions of str (from 1 
    // to str.length() - 1) -
    // Checks if the substring from the beginning (str.substring(0, i)) 
    // exists in the Trie (search(str.substring(0, i))).
    // Recursively checks if the remaining substring (str.substring(i)) 
    // can also be segmented (wordBreak(str.substring(i))).
    // If both conditions are true for any partition, it returns true.
    // If no partitions are valid, it checks if the entire str itself 
    // exists as a single word in the Trie (search(str)).
    // Returns true or false based on whether str can be segmented using 
    // words from the Trie.

    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        System.out.println(wordBreak(key));
    }
}

/*
    Initialization and Insertion
    Input -
    String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
    String key = "ilikesamsung";
    Action - Insert words into the Trie using insert().

    Word "i" -
        i -> index = 'i' - 'a' = 8
        A new Node is created at root.children[8].
        The node is marked as isEndOfWord = true.

    Word "like" -
        l -> index = 'l' - 'a' = 11
        A new Node is created at root.children[11].
        i -> index = 'i' - 'a' = 8
        A new Node is created at root.children[11].children[8].
        k -> index = 'k' - 'a' = 10
        A new Node is created at 
        root.children[11].children[8].children[10].
        e -> index = 'e' - 'a' = 4
        A new Node is created at 
        root.children[11].children[8].children[10].children[4].

    The final node is marked as isEndOfWord = true.
    The same process is repeated for "sam", "samsung", "mobile", and "ice".

    Checking Word Break - wordBreak("ilikesamsung")

        Iteration 1 -
            The string is "ilikesamsung".
            Partition the string at each index i and check:
            i = 1 -
            Prefix - "i", Suffix - "likesamsung"
            Check search("i") -
            Traverse to root.children[8] and find isEndOfWord = true.
            Recursive call - wordBreak("likesamsung").

        Iteration 2 -
            The string is "likesamsung".
            Partition the string at each index i and check -

            i = 1 -
                Prefix - "l", Suffix - "ikesamsung"
                Check search("l") -
                No node at root.children[11].
                Return false.
            i = 2 -
                Prefix - "li", Suffix - "kesamsung"
                Check search("li") -
                No matching nodes.
                Return false.
            i = 3 -
                Prefix - "lik", Suffix - "esamsung"
                Check search("lik") -
                No matching nodes.
                Return false.
            i = 4 -
            Prefix - "like", Suffix - "samsung"
            Check search("like") -
            Traverse through nodes and find isEndOfWord = true.
            Recursive call - wordBreak("samsung").

        Iteration 3 -
            The string is "samsung".
            Partition the string at each index i and check:
            i = 3 -
            Prefix - "sam", Suffix - "sung"
            Check search("sam") -
            Traverse through nodes and find isEndOfWord = true.
            Recursive call - wordBreak("sung").

        Iteration 4 -
            The string is "sung".
            Partition the string and check -
            All partitions fail because "sung" is not in the Trie.
            Check search("samsung") as a whole -
            Traverse through nodes and find isEndOfWord = true.

    3. Final Output
    The recursive calls return true in sequence -
        wordBreak("samsung") → true.
        wordBreak("likesamsung") → true.
        wordBreak("ilikesamsung") → true.

    Output - true

    Flow Diagram -
        Insert words into the Trie.

        Call wordBreak("ilikesamsung") -
        Partition - "i" + "likesamsung" → Recursive check.

        Call wordBreak("likesamsung") -
        Partition - "like" + "samsung" → Recursive check.

        Call wordBreak("samsung") -
        Partition - "samsung" found as a whole word.
*/