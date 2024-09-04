import java.util.*;

public class CreatePrint {
    public static void main(String args[]){
        double marks[] = new double[100];
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the marks of physics - ");
        marks[0] = sc.nextDouble();
        System.out.print("Enter the marks of Chemistry - ");
        marks[1] = sc.nextDouble();
        System.out.print("Enter the marks of Maths - ");
        marks[2] = sc.nextDouble();
        System.out.println("Physics - " + marks[0]);
        System.out.println("Chemistry - " + marks[1]);
        System.out.println("Maths - " + marks[2]);
        double percentage = (marks[0]+marks[1]+marks[2])/3;
        System.out.println("Percentage - " + percentage + "%\n");
        sc.close();
    }
}