public class CountSetBits {
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            // Checking out the least significant bit
            if(((n&1) != 0)){ 
                count++;
            }
            // Right shift the bits of n by 1
            n = n >> 1;
        }
        return count;
    }
    public static void main(String args[]){
        System.out.println("\nSet Bits count - " + countSetBits(31) + "\n"); // Output: 5
    }
}