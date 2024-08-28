public class ArithmeticOperators {
    public static void main(String args[]){
        int a = 10;
        int b = 5;

        // Binary operators -
        int c = a - b;
        int d = a + b;
        int e = a * b;
        int f = a / b;
        int g = a % b;
        System.out.println("Subtraction: " + c);
        System.out.println("Addition: " + d);
        System.out.println("Multiplication: " + e);
        System.out.println("Division: " + f);
        System.out.println("Remainder: " + g);

        //Unary operators -
        int h = --a; 
        System.out.println("Pre-decrement: " + h); // 9 aajayega
        int i = b--;
        System.out.println("Post-decrement: " + i); // 5 hi aayega
        int j = ++a;
        System.out.println("Pre-increment: " + j); // 10 aajayega
        int k = b++;
        System.out.println("Post-increment: " + k); // 4 aayega
    }   
}