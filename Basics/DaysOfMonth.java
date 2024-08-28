import java.util.*;

public class DaysOfMonth {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the month number - ");
        int month = sc.nextInt();
        if(month == 2){
            System.out.println("Days in month - 28\n");
        }else if(month < 8){
            if(month % 2 == 0){
                System.out.println("Days in month - 30\n");
            }else{
                System.out.println("Days in month - 31\n");
            }
        }else{
            if(month % 2 == 0){
                System.out.println("Days in month - 31\n");
            }else{
                System.out.println("Days in month - 30\n");
            }
        }
        sc.close();
    }
}