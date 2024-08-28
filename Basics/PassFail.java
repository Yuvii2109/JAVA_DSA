import java.util.*;

public class PassFail {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your marks - ");
        float marks = sc.nextFloat();
        String PassFail = (marks > 33) ? "You've cleared the exam" : "Better Luck next time";
        System.out.println(PassFail + "\n");
        sc.close();
    }
}