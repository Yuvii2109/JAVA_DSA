import java.util.*;

public class PositiveNegative {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        float a = sc.nextFloat();
        String checking = (a > 0) ? 
        "It's a positive number\n" : (a < 0 ) ?
        "It's a negative number\n" : "It's zero\n";
        System.out.println(checking);
        sc.close();
    }
}