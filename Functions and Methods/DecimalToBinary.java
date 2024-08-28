import java.util.Scanner;

public class DecimalToBinary {
    public static void decToBin(int decNum){
        int pow = 0;
        int binNum = 0;
        int decNumCpy = decNum;
        while(decNum > 0){
            int rem = decNum % 2;
            binNum += (int)Math.pow(10, pow) * rem;
            pow++;
            decNum = decNum / 2;
        }
        System.out.println("Binary Number of - " + decNumCpy + " is - " + binNum + "\n");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the decimal number - ");
        int n = sc.nextInt();
        decToBin(n);
        sc.close();
    }
}