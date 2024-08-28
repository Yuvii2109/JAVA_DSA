import java.util.*;

public class InputFull {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        /* Ab scene kya hai boss ki next sirf space
        aane tk ki cheez ko input krta hai toh agr hme
        poore naam ki aavashyakta hain toh uske liye sc.nextLine()*/

        System.out.print("Enter your name: ");
        String full = sc.nextLine();
        System.out.println("Hello, " + full + "!");
        sc.close();
    }
}