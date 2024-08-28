import java.util.*;

public class OddEven {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int num = sc.nextInt();
        if(num%2 == 0){
            System.out.println(num + " is even\n");
        }else{
            System.out.println(num + " is odd\n");
        }
        sc.close();
    }
}