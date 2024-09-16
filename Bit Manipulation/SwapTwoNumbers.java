// Toh code shuru krne se pehle ek gyaan ke baat...
// The value of x^x = 0.
// Think about it, xor gives 0 when the bits are the same. If we compare the same number to
// itself, the bits will always be the same. So, the answer of x^x will always be 0.
// Or haan yeh neeche wala code hme XOR ka use krte hue likhna hai... 

public class SwapTwoNumbers {
    public static void main(String args[]){
        int a = 5;
        int b = 10;
        System.out.println("\nBefore swapping: a = " + a + ", b = " + b);

        // Applying XOR swapping -
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping: a = " + a + ", b = " + b + "\n");
    }
}

// Ab bologe yoon ki yeh kaise hua ? Toh bhai aaya hai na... samjhakr jaayega -
// XOR swapping is a technique used to swap two numbers without using a temporary variable.
// It works by using the XOR operator (^) to swap the values of two variables.
// The XOR operator returns 1 if the two bits are different, and 0 if they are
// the same. Toh, yahan a = 5 = 0101, and b = 10 = 1010. Ab agar hm likhen 
// a = a ^ b; toh a = 0101 ^ 1010 = 1111 and then, b = a ^ b; toh b = 
// 1111 ^ 1010 = 0101 = 5. Finally, a = a ^ b; again => a = 1111 ^ 0101 = 1010 = 10
// So, the values of a and b are swapped. Yehi hai XOR swapping ka concept... Tadaaaa!!!!