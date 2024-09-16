public class ClearRangeOfBits {
    public static int clearRangeOfBits(int n, int start, int end) {
        int a = ((~0)<<(end)); 
        if(start > 1){
            a = a | (1<<(start-2));
        }else if(start == 0 | start == 1){
            a = a | 0;
        }else{
            return 0;
        }
        return n & a;
    }
    public static void main(String[] args) {
        System.out.println("\n" + clearRangeOfBits(31, 2, 4) + "\n");
    }
}

// 31 in binary is - 00011111 toh ab ise hm krna kya chahte hain is - 
// 00011111 ko 00010001 karna hain toh yaar iske liye settlement bithane ke liye 
// ~0 = 11111111 hota hai usko left shift krdiya hai by end = 4 makes it 
// 11110000 or 1 ko left shift krdia hai by start-2 = 0 makes it 00000001
// toh iss sab ke baad apn lete hain 11110000 | 00000001 which is 
// 11110001 aur ab apan log krdege 00011111 & 11110001 which comes out to be
// 00010001 which is 17 in decimal