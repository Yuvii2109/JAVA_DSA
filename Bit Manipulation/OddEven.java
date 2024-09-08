import java.util.Scanner;

public class OddEven {
    // Toh pehle toh tera bhai tujhe gyaan deta hai... chl binary kren
    // 0 = 000, 1 = 001, 2 = 010, 3 = 011, 4 = 100, 5 = 101, 6 = 110...
    // Kuch notice kiya bhai ??? - har odd binary number ka least significant
    // bit 1 hai, aur har even binary number ka least significant bit 0 hai
    // chal smjhgya na ... ab code dekh apne bhai ka biduuu!!!
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int n = sc.nextInt();
        int a = n&1;
        if(n < 0){
            System.out.println("Negative number\n");
        }else if(n == 0){
            System.out.println("Zero is neither odd nor even\n");
        }else if(a == 0){
            System.out.println("Even Number\n");
        }else{
            System.out.println("Odd Number\n");
        }
        sc.close();
    }
}