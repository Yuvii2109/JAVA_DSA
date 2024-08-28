import java.util.Scanner;

public class BinaryToDecimal {
    public static void binToDec(int binNum){
        int pow = 0;
        int decNum = 0;
        int binNumCpy = binNum;
        while(binNum > 0){
            int lastDigit = binNum%10;
            decNum += (lastDigit*(int)Math.pow(2,pow));
            pow++;
            binNum = binNum/10;
        }
        System.out.println("Decimal Form of - "+ binNumCpy + " is - " + decNum + "\n");
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the binary number - ");
        int a = sc.nextInt();
        binToDec(a);
        sc.close();
    }
}