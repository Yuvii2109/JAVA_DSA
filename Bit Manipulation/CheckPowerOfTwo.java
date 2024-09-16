import java.util.Scanner;

public class CheckPowerOfTwo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int n = sc.nextInt();
        if (n > 0) {
            if((n & (n-1)) == 0){
                System.out.println(n + " is a power of 2\n");
            }else{
                System.out.println(n + " is not a power of 2\n");
            }
        }else{
            System.out.println(n + " is not a power of 2\n");
        }
        sc.close();
    }
}

// Sab chodh pehle logic pakad bhai... Toh! shuru se shuru krte hain - 
// 1. 2^0 = 1, 2^0-1 = 0 and 1 & 0 = 0 => 2^0 & 2^0-1 = 0, similarly -
// 2. 2^1 = 2, 2^1-1 = 1 and 2(10) & 1 = 0 => 2^1 & 2^1-1 = 0, similarly -
// 3. 2^2 = 4, 2^2-1 = 3 and 4(100) & 3(011) = 0 => 2^2 & 2^2-1 = 0, similarly -
// 4. 2^3 = 8, 2^3-1 = 7 and 8(1000) & 7(0111) = 0 => 2^3 & 2^3-1 = 0, keeps going on...