import java.util.*;

public class OddEveSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of inputs you want to make - ");
        int n = sc.nextInt();
        System.out.println();
        int sumOdd = 0, sumEven = 0;
        for(int i=0; i<n; i++){
            System.out.print("Enter the number - ");
            int num = sc.nextInt();
            if(num % 2 == 0){
                sumEven += num;
            }else{
                sumOdd += num;
            }
        }
        System.out.println("Sum of odd numbers - " + sumOdd);
        System.out.println("Sum of even numbers - " + sumEven);
        System.out.println();
        sc.close();
    }
}