// Input two numbers from user loweLimit and upperLimit and print numbers 
// within the range that have digits in strict increasing order.

import java.util.Scanner;

public class PrintInRange {
    public static void printInRange(int l, int u){
        for(int i=l;i<=u;i++){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lower limit - ");
        int lowerLimit = sc.nextInt();
        System.out.print("Enter the upper limit - ");
        int upperLimit = sc.nextInt();
        printInRange(lowerLimit, upperLimit);
    }
}