public class ClearIthBit {
    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);  
        return n & bitMask;
    }
    public static void main(String[] args) {
        System.out.println("\n" + clearIthBit(10, 1) + "\n");       
    }
}

// 10 in binary is 1010, now 1>>2 = 100 and now 1010&0100 = 1000 = 8