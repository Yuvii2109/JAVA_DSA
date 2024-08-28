import java.util.*;

public class Input {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String input = sc.next();
        System.out.println("Hello, " + input + "!");
        sc.close();
    }
}