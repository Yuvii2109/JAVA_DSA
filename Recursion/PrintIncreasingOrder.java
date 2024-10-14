public class PrintIncreasingOrder {
    public static void printInc(int n){
        // Base Condition - 
        // This if statement checks if n equals 1. 
        // If true, it prints 1 followed by a space (" "), 
        // then returns from the function using return;
        // This is the base case of the recursion, which 
        // stops further recursive calls when n reaches 1.
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        printInc(10);
    }
}
// How it works - 
// For example, if printInc(5) is called:
// printInc(5) calls printInc(4), which calls printInc(3), 
// and so on until printInc(1). Once printInc(1) is reached, it prints 1.
// As the recursive calls return, printInc(2) prints 2, printInc(3) 
// prints 3, and so on up to printInc(5) printing 5. Therefore, 
// the function prints numbers from 1 to n in increasing order.