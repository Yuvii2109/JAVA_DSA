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
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
    }
}