/*
    You are given an array of strings words. Each element of words consists of two lowercase English letters.

    Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

    Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

    A palindrome is a string that reads the same forward and backward. 

    Example 1 -
        Input - words = ["lc","cl","gg"]
        Output - 6
        Explanation - One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
        Note that "clgglc" is another longest palindrome that can be created.

    Example 2 -
        Input - words = ["ab","ty","yt","lc","cl","ab"]
        Output - 8
        Explanation - One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
        Note that "lcyttycl" is another longest palindrome that can be created.

    Example 3 -
        Input - words = ["cc","ll","xx"]
        Output - 2
        Explanation - One longest palindrome is "cc", of length 2.
        Note that "ll" is another longest palindrome that can be created, and so is "xx".
*/

public class LongestPalindromeByConcatenating2LetterWords {
    public int longestPalindrome(String[] words) {
        // cnt[i][j] = how many unused words equal to (char)('a'+i) + (char)('a'+j)
        int[][] cnt = new int[26][26];
        int length = 0;

        // Form as many reverse‐pairs as possible
        for(String w : words){
            int x = w.charAt(0) - 'a';
            int y = w.charAt(1) - 'a';
            if(cnt[y][x] > 0){
                // Found a reverse match - example, w="ab" and we had an unused "ba"
                cnt[y][x]--;
                length += 4; 
                // Each word is length 2, so together they add 4
            }else{
                cnt[x][y]++; // No reverse match yet - record this word for future pairing
            }
        }
        // Check if we can put one "aa", "bb", ..., "zz" in the center
        for(int i = 0; i < 26; i++){
            if(cnt[i][i] > 0){
                // We only need one such word in the middle
                length += 2;
                break;
            }
        }
        return length;
    }
}