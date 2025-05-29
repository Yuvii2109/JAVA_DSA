/*
    Reverse bits of a given 32 bits unsigned integer.

    Note - Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.

    In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825. 

    Example 1 -
        Input - n = 00000010100101000001111010011100
        Output - 964176192 (00111001011110000010100101000000)
        Explanation - The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

    Example 2 -
        Input - n = 11111111111111111111111111111101
        Output - 3221225471 (10111111111111111111111111111111)
        Explanation - The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
*/

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        // Loop exactly 32 times, once for each bit in the 32-bit integer.
        for(int i = 0; i < 32; i++){
            // Shift 'reversed' left by 1 to make room for the next bit. On the very first iteration, reversed was 0, so shifting keeps it 0.
            reversed <<= 1;
            // Extract the least significant bit of 'n' (n & 1 gives 0 or 1) and OR it into the now-vacant least significant position of 'reversed'. This “appends” the bit we just pulled off of n.
            reversed |= (n & 1);
            // Shift 'n' right by 1, using unsigned shift >>> - This moves the next bit of 'n' into the LSB position for the next round. Because it’s >>>, we always fill the left with 0 (treating it as unsigned).
            n >>>= 1; 
        }
        return reversed;
    }
}