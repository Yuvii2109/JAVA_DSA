import java.util.*;

public class UsingElseIf {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your age - ");
        int age = sc.nextInt();
        if(age>18){
            System.out.println("You are an adult\n");
        }else if(age>13){
            System.out.println("You are a teenager\n");
        }else{
            System.out.println("You are a kid\n");
        }
        sc.close();
    }
}