// We are given a string S, we need to find the count of all contiguous substrings
// starting and ending with the same character.
// Sample Input 1 : S = "abcab"
// Sample Output 1 : 7
// There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b
// Out of the above substrings, there are 7 substrings : a, abca, b, bcab, c, a and b. So, only 7
// contiguous substrings start and end with the same character.

public class PracticQuestionFour {
    public static int countSubString(String str, int i, int j, int n){
        if(n == 1){
            return 1;
        }
        if(n <= 0){
            return 0;
        }
        int res = countSubString(str, i+1, j, n-1)
        // Pehle index ko chodhkr dekhege
        // ("abcab", 1, 4, 4) - step 1 -> range = "bcab"
        // ("abcab", 2, 4, 3) - step 2 -> range = "cab"
        // ("abcab", 3, 4, 2) - step 3 -> range = "ab"
        // ("abcab", 4, 4, 1) - step 4 -> range = "b" isme toh 1 hi return ho jayega
        + countSubString(str, i, j-1, n-1)
        // Aakhri index ko chodhkr dekhege
        // ("abcab", 0, 3, 4) - step 1 -> range = "abca"
        // ("abcab", 0, 2, 3) - step 2 -> range = "abc"
        // ("abcab", 0, 1, 2) - step 3 -> range = "ab"
        // ("abcab", 0, 0, 1) - step 4 -> range = "a" returns 1
        - countSubString(str, i+1, j-1, n-2);
        // Pehla or aakhri index dono ko chodhkr dekhege
        // ("abcab", 1, 3, 3) - step 1 -> range = "bca"
        // ("abcab", 2, 2, 1) - step 2 -> range = "c" returns 1
        if(str.charAt(i) == str.charAt(j)){
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "abcab";
        int n = str.length();
        System.out.print(countSubString(str, 0, n-1, n));
    }
}

// Jhoot toh nahi bhuloonga yaar - Recursive case ratna pdega