import java.util.*;

public class ForTable {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number you wish to find table of - ");
        int n = sc.nextInt();
        System.out.print("\n");
        for(int i = 1; i <= 10; i++){
            if(i < 10){
                System.out.println(n + " x " + i + " = " + n * i);
            }else{
                System.out.println(n + " x " + i + " = " + n * i + "\n");
            }
        }
        sc.close();
    }
}