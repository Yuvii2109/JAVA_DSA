import java.util.Scanner;

public class PallindromeFunction {
    public static void PallindromeTest(int n){
        int temp = n;
        int rev = 0;
        while(temp>0){
            int rem = temp%10;
            rev = rev*10 + rem;
            temp = temp/10;
        }
        if(n==rev){
            System.out.println(n + " is a palindrome\n");
        }else{
            System.out.println(n + " is not a palindrome\n");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number to test - ");
        int n = sc.nextInt();
        PallindromeTest(n);
        sc.close();
    }
}