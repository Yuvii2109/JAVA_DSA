import java.util.*;

public class CharToNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character - ");
        char ch = sc.next().charAt(0);
        int num = (int)ch;
        System.out.println("Number associated to the character is - " + num);
        sc.close();
    }
}