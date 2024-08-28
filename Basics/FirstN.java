import java.util.*;

public class FirstN {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number upto which you want to generate the consecutive count - ");
        int n = sc.nextInt();
        int count = 1;
        while(count <= n){
            if(count < n){
                System.out.print(count + ", ");
            }else{
                System.out.println(count + "\n");
            }
            count++;
        }
        sc.close();
    }
}