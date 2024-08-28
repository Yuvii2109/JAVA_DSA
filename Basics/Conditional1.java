import java.util.*;

public class Conditional1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your age - ");
        int age = sc.nextInt();
        if(age >= 18){
            System.out.println("You are eligible to vote.\n");
        }else{
            System.out.println("You are not eligible to vote.\n");
        }
        sc.close();
    }
}