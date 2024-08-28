import java.util.*;

public class DaysOfWeek {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number and I will give you the corresponding day of the week - ");
        int n = sc.nextInt();
        switch(n){
            case 1:
                System.out.println("Monday\n");
                break;
            case 2:
                System.out.println("Tuesday\n");
                break;
            case 3:
                System.out.println("Wednesday\n");
                break;
            case 4:
                System.out.println("Thursday\n");
                break;
            case 5:
                System.out.println("Friday\n");
                break;  
            case 6:
                System.out.println("Saturday\n");
                break;
            case 7:
                System.out.println("Sunday\n");
                break;
            default: 
                System.out.println("Sharam aati hai?\n");
        }
        sc.close();
    }
}