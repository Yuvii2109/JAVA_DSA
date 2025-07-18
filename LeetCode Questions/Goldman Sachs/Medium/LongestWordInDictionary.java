/*
    Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

    If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

    Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

    Example 1 -
        Input - words = ["w","wo","wor","worl","world"]
        Output - "world"
        Explanation - The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

    Example 2 -
        Input - words = ["a","banana","app","appl","ap","apply","apple"]
        Output - "apple"
        Explanation - Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
*/

public class LongestWordInDictionary {
    private static class TrieNode{
        TrieNode[] kids = new TrieNode[26];
        boolean isWord = false;
    }
    private final TrieNode root = new TrieNode();
    private String best = "";
    public String longestWord(String[] words) {
        for(String w : words){
            insert(w);
        }
        dfs(root, new StringBuilder());
        return best;
    }
    private void insert(String w){
        TrieNode node = root;
        for(char c : w.toCharArray()){
            int i = c - 'a';
            if(node.kids[i] == null){
                node.kids[i] = new TrieNode();
            }
            node = node.kids[i];
        }
        node.isWord = true;
    }
    private void dfs(TrieNode node, StringBuilder sb){
        for(int i = 0; i < 26; i++){
            TrieNode child = node.kids[i];
            if(child != null && child.isWord){
                sb.append((char)(i + 'a'));
                String candidate = sb.toString();
                if((candidate.length() > best.length()) || 
                (candidate.length() == best.length() && candidate.compareTo(best) < 0)){
                    best = candidate;
                }
                dfs(child, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}