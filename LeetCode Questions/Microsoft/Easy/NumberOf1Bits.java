/*
    Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight). 

    Example 1 -
        Input - n = 11 
        Output - 3 
        Explanation - The input binary string 1011 has a total of three set bits.

    Example 2 -
        Input - n = 128
        Output - 1
        Explanation - The input binary string 10000000 has a total of one set bit.

    Example 3 - 
        Input - n = 2147483645
        Output - 30
        Explanation - The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
*/

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0; // Holds the count of all the set bits
        while(n != 0){
            // Clear the least significant bit set (LSB) by doing: n = n & (n - 1), Explanation - If n is 1011 (11 in decimal), then n - 1 = 1010. Performing n & (n - 1) removes the least significant set bit from n.
            n = n & (n-1);
            count++;
        }
        return count;
    }
}