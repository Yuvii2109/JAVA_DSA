import java.util.Scanner;

public class PallindromeString {
    public static boolean isPallindrome(String str){
        int i = 0, j = str.length();
        for(i = 0; i < j/2; i++){
            if(str.charAt(i) != str.charAt(j-i-1)){
                // Not a pallindrome 
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a string - ");
        str = sc.nextLine();
        if(isPallindrome(str)){
            System.out.println("String is a palindrome\n");
        }else{
            System.out.println("String is not a palindrome\n");
        }
        sc.close();
    }
}