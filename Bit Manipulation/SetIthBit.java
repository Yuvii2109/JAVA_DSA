import java.util.*;

public class SetIthBit {
    public static int setIthBit(String n, int i) {
        int num = Integer.parseInt(n);
        return num | (1 << i-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the binary number - ");
        String binary = sc.nextLine();
        System.out.print("Enter the index you want to set - ");
        int index = sc.nextInt();
        System.out.println("\nThe binary number after setting the bit is - " + setIthBit(binary, index) + "\n");
        sc.close();
    }
}

// Output desired nahi aayega but logic yehi hai yaar ...