public class LongestSubstringWithoutRepititionOfCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0;
        // The left pointer moves forward when duplicate characters appear to keep the substring valid.
        for(int right = 0; right < s.length(); right++){
            // The right pointer expands the window to include new characters.
            char current = s.charAt(right);
            if(map.containsKey(current) && map.get(current) >= left){
                // If the character exists in map and is inside the current window (i.e., charMap.get(currentChar) >= left), we must move left forward to ensure no duplicates exist. left = charMap.get(currentChar) + 1; moves left past the duplicate character.
                left = map.get(current) + 1;
            }
            map.put(current, right);
            maxLength = Math.max(maxLength, (right-left+1));
        }
        return maxLength;
    }
}