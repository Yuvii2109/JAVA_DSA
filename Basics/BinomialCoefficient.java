import java.util.*;

public class BinomialCoefficient {
    public static int factorial(int a){
        int fact = 1;
        for(int i = a; i >= 1; i--){
            fact = fact*i;
        }
        return fact;
    }
    public static int nCr(int n, int r){
        int factN = 1;
        int factR = 1;
        int factNR = 1;
        if(n >= r){
            factN = factorial(n);
            factR = factorial(r);
            factNR = factorial(n-r);
        }else{
            System.out.println("Enter correct inputs man!");
        }
        int nCr = factN / (factR * factNR);
        return nCr;
    }
    public static void main(String args[]){
        System.out.println("\nAree chill kr bhai... number of combinations ka formula hota hai... nCr!!!");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the value of n - ");
        int n = sc.nextInt();
        System.out.print("Enter the value of r - ");
        int r = sc.nextInt();
        System.out.println("\nNumber of combinations - " + nCr(n, r) + "\n");
        sc.close();
    }
}