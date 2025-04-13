/*
    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same. Return any possible rearrangement of s or return "" if not possible.

    Example 1 -
        Input - s = "aab"
        Output - "aba"

    Example 2 -
        Input - s = "aaab"
        Output - ""
*/

public class ReorganizeString {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] frequency = new int[26];
        for(int c : s.toCharArray()){
            frequency[c - 'a']++;
        }

        // Finding the character with maximum frequency
        int maxFrequency = 0, maxCharacter = 0;
        for(int i = 0; i < 26; i++){
            if(frequency[i] > maxFrequency){
                maxFrequency = frequency[i];
                maxCharacter = i;
            }
        }

        if(maxFrequency > (n+1)/2) return "";

        // Filling even positions first
        char[] result = new char[n];
        int index = 0;

        // Placing the most frequent character
        while(frequency[maxCharacter] > 0){
            result[index] = (char)(maxCharacter + 'a');
            index += 2;
            frequency[maxCharacter]--;
        }

        // Placing the rest
        for(int i = 0; i < 26; i++){
            while(frequency[i] > 0){
                if(index >= n) index = 1; // Switching to odd positions
                result[index] = (char)(i + 'a');
                index += 2;
                frequency[i]--;
            }
        }
        return new String(result);
    }
}