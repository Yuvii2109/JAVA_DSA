import java.util.Scanner;

public class Diamond {
    public static void diamond(int n){
        // Upper half of the diamond
        for(int i = 1; i <= n; i++){
            // Printing spaces before the stars
            for(int j = 1; j <= n-i; j++){
                System.out.print("     ");
            }
            // Printing stars
            for(int j = 1; j <= 2*i-1; j++){
                System.out.print("*    ");
            }
            // Moving to the next line after each row
            System.out.println();
        }
        
        // Lower half of the diamond
        for(int i = n-1; i >= 1; i--){
            // Printing spaces before the stars
            for(int j = 1; j <= n-i; j++){
                System.out.print("     ");
            }
            // Printing stars
            for(int j = 1; j <= 2*i-1; j++){
                System.out.print("*    ");
            }
            // Moving to the next line after each row
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows of upper half - ");
        int n = sc.nextInt();
        diamond(n); // Calling the diamond method with user input
        System.out.println();
        sc.close(); // Closing the scanner
    }
}