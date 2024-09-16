public class ClearLastIBits {
    public static int clearLastIBits(int n, int i){
        return n & ((~0) << i);
    }
    public static void main(String[] args) {
        System.out.println("\n" + clearLastIBits(10, 2) + "\n");
    }
}

// Ab iss wale main ~0 kyu liya..? Vo isliye kyuki ~0 = 1111111111 toh agar hum use
// left shift karte hai ton toh depending upon the i which is 2 here 1111111111 ban 
// jayega 1111111100 and jb yeh wala number & hoga n ke saath toh last ke i bits clear ho jayenge