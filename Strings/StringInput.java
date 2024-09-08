import java.util.Scanner;

public class StringInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.print("\nEnter your name - ");
        name = sc.nextLine();
        System.out.println("Hello, " + name + "\n");
        sc.close();
    }
}