import java.util.Scanner;

public class LowercaseVowels {
    public static void countLowerVowels(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'a':
                    count++;
                    break;
                case 'e':
                    count++;
                    break;
                case 'i':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Number of lowercase vowels - " + count + "\n");
    }
    public static void main(String[] args) {
        String str; 
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a string - ");
        str = sc.nextLine();
        countLowerVowels(str);
        sc.close();
    }
}