import java.util.*;

public class Switch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the suvidha - ");
        int suvidha = sc.nextInt();
        switch (suvidha) {
            case 1: 
                System.out.println("Ee lo aapra momoj...\n");
                break;
            case 2: 
                System.out.println("Ee lo aapre chilly potato...\n");
                break;
            case 3: 
                System.out.println("Ee lo aapri ice cream...\n");
                break;
            default: 
                System.out.println("Menu main se order kr na...\n");
        }
        sc.close();
    }
}