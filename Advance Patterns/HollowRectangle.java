import java.util.Scanner;

public class HollowRectangle {
    public static void rectangle(int rows, int columns){
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                if(i == 1 || i == rows || j == 1 || j == columns){
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the unit length of the rectangle - ");
        int columns = sc.nextInt();
        System.out.print("Enter the unit width of the rectangle - ");
        int rows = sc.nextInt();
        rectangle(rows, columns);
        sc.close();
    }
}