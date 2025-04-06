/*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers. Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1 -
    Input - s = "A man, a plan, a canal: Panama"
    Output - true
    Explanation - "amanaplanacanalpanama" is a palindrome.

    Example 2 -
    Input - s = "race a car"
    Output - false
    Explanation - "raceacar" is not a palindrome.

    Example 3 -
    Input - s = " "
    Output - true
    Explanation - s is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.
*/

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