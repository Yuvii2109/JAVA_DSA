import java.util.Scanner;

public class GetIthBit {
    public static int getIthBit(String n, int i){
        int num = Integer.parseInt(n);
        int bit = (num >> i-1) & 1;
        return bit;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a Binary number - ");
        String binary = sc.nextLine();
        System.out.print("Enter the position of the bit you want to get - ");
        int position = sc.nextInt();
        int ithBit = getIthBit(binary, position);
        System.out.println("\nThe bit at position " + position + " is "  + ithBit + "\n");
        sc.close();
    }
}