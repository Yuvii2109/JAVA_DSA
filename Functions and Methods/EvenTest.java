import java.util.Scanner;

public class EvenTest {
    public static boolean isEven(int n){
        boolean isEven = false;
        if (n % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number you want to test - ");
        int num = sc.nextInt();
        if (isEven(num)){
            System.out.println(num + " is even.\n");
        }else{
            System.out.println(num + " is odd.\n");
        }
        sc.close();
    }
}