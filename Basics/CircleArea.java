import java.util.*;

public class CircleArea {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle - ");
        float rad = sc.nextFloat();
        double pi  = 3.14;
        double area = pi*rad*rad;
        System.out.println("The area of the circle is - "+area);
        sc.close();
    }
}