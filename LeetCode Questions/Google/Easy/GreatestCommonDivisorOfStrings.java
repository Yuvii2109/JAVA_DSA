/*
    For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times). Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2. 

    Example 1 -
        Input - str1 = "ABCABC", str2 = "ABC"
        Output - "ABC"

    Example 2 -
        Input - str1 = "ABABAB", str2 = "ABAB"
        Output - "AB"

    Example 3 -
        Input - str1 = "LEET", str2 = "CODE"
        Output - ""
*/

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // If str1 + str2 != str2 + str1, there's no repeating pattern, in that case, no non-empty string can divide both.
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        // Computing the greatest common divisor of the two lengths. Any common divisor-string must have length dividing both |str1| and |str2|
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLen = gcd(len1, len2);
        // The prefix of either string of length gcdLen is the answer.
        return str1.substring(0, gcdLen);
    }

    // Standard Euclidean algorithm for GCD of two positive integer.
    private int gcd(int a, int b){
        // If b == 0, then gcd(a, 0) = a
        if(b == 0) return a;
        // Otherwise recurse with (b, a%b)
        return gcd(b, a%b);
    }    
}

/*
    str1 = "ABCABC";
    str2 = "ABC";

    Check concatenation commutativity - 
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        str1 + str2 is "ABCABC" + "ABC" → "ABCABCABC".
        str2 + str1 is "ABC" + "ABCABC" → "ABCABCABC".
        They are equal, so we do not return "" here. We proceed.

    Compute lengths and their GCD - 
        int len1 = str1.length();  // 6
        int len2 = str2.length();  // 3
        int gcdLen = gcd(len1, len2);
        len1 = 6, len2 = 3.

        Call gcd(6, 3) -
            gcd(6, 3) - since b != 0, return gcd(3, 6 % 3)
            gcd(3, 0) - since b == 0, return a = 3
                So gcdLen = 3.

    Take the prefix of length gcdLen - 
        return str1.substring(0, gcdLen);
        str1.substring(0, 3) extracts the first 3 characters of "ABCABC", which is "ABC".

    Final result - The method returns "ABC", which is indeed the largest string that “divides” both "ABCABC" (twice) and "ABC" (once).
*/