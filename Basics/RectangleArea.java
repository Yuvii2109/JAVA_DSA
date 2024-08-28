import java.util.*;

public class RectangleArea {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThis program is to find out the length of a rectangle...\n");
        System.out.print("Enter the length of the reactangle - ");
        float l = sc.nextFloat();
        System.out.print("Enter the breadth of the rectangle - ");
        float b = sc.nextFloat();
        float area = l*b;
        System.out.println("The area of the rectangle is - " + area);
        sc.close();
    }
}