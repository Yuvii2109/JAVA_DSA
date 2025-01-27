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
    public static class Node{
        Node[] children = new Node[26]; // 26 letters in the English alphabet
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
            int index = word.charAt(i) - 'a'; // Convert char to index
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
            int index = key.charAt(i) - 'a'; // Convert char to index
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(String word : words){
            insert(word);
        }
        System.out.println(search("the"));  // true
        System.out.println(search("thee")); // true
        System.out.println(search("th")); // false
    }
}