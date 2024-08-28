import java.util.*;

public class TypeConversion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number - ");
        float num = sc.nextInt();
        System.out.print("Converted type from int to float - " + num);
        sc.close();
    }
}