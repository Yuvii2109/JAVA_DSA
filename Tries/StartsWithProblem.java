// Create a function boolean startsWith(String prefix) for a trie. 
// Returns true if there is a word in the trie that starts with the 
// given prefix, otherwise returns false.
// Example - {"apple", "app", "mango", "man", "woman"}
// startsWith("app") returns True
// startsWith("h") return False

public class StartsWithProblem {
    public static class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    public static boolean startsWith(String prefix){
        Node current = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        for(String word : words){
            insert(word);
        }
        System.out.println(startsWith("app"));
        System.out.println(startsWith("yu")); 
    }
}