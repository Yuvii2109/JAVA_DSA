import java.util.Scanner;

public class StringLength {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String name;
            System.out.print("\nEnter your name - ");
            name = sc.nextLine();
            System.out.println("String length - " + name.length() + "\n");
            sc.close();
        }
}