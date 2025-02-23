public class ValidPalindromeString {
    // public boolean isPalindrome(String s) {
    //     if(s.trim().isEmpty()) return true;
    //     String newStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    //     int left = 0, right = newStr.length()-1;
    //     boolean result = false;
    //     while(left <= right){
    //         if(newStr.charAt(left) != newStr.charAt(right)){
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
    // Time Complexity - O(n), Space Complexity - O(n) because this method requires the creation of another string... We must find a way which gives us O(1) space complexity
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
        // Time complexity - O(n), Space Complexity - O(1)
    }
}