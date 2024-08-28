import java.util.*;

public class CharacterPattern {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPrefer entering a number less than 7");
        System.out.print("\nEnter the number of rows - ");
        int n = sc.nextInt();
        char ch = 'A';
        for(int line = 1; line <= n; line++){
            for(int chars = 1; chars <= line; chars++){
                System.out.print(ch + "     ");
                ch++;
            }
            System.out.println();
        }
        sc.close();
    }
}