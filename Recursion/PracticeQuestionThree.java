public class PracticeQuestionThree {
    // Write a program to find Length of a String using Recursion.
    public static int length(String str){
        if(str.length() == 0){
            return 0;
        }else{
            return (1 + length(str.substring(1)));
        }
    }
    public static void main(String[] args) {
        System.out.println(length("Hello"));  // Output: 5
    }
}

// The substring(1) method creates a new string by removing the 
// first character of str. This means the original string gets 
// progressively smaller with each call. For example, if str = "Hello", 
// calling str.substring(1) gives "ello". With each recursive step, the string becomes - 
// "ello" -> "llo" -> "lo" -> "o" -> "" (an empty string)

// Reason behind the addition of 1 in the final answer - 
// The reason behind the addition of 1 in the final answer is that we are counting the length
// of the string. When we call str.substring(1), we are removing the first character of
// the string. So, we need to add 1 to the length of the remaining string to
// get the total length of the original string. For example - 
// if str = "abc", the recursive calls will be:

// First call: length("abc") returns 1 + length("bc")
// Second call: length("bc") returns 1 + length("c")
// Third call: length("c") returns 1 + length("")
// Base case: length("") returns 0
// When the base case is reached, the recursion starts to return back up the call stack, adding 1 each time:

// length("c") becomes 1 + 0 = 1
// length("bc") becomes 1 + 1 = 2
// length("abc") becomes 1 + 2 = 3
// So, the final result is 3, which is the length of "abc".