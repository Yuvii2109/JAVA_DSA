public class FastExponentiation {
    public static int fastExpo(int base, int pow){
        int ans = 1;
        while(pow > 0){
            if((pow&1) != 0){
                ans *= base;
            }
            base *= base;
            pow = pow >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("\nRequired answer = " + fastExpo(3, 5) + "\n");
    }
}

// Aajao bhai Gyaan Ka prachar shuru hi hone wala hai... toh... mudde par aate hain -
// Fast Exponentiation - basically competitive question to determine about how we can 
// reduce the time complexity of the exponentiation problem. Method ko dhyaan se dekhen toh
// ans variable set krlia = 1 and ab utha lete hain input ko direct toh base = 3 and 
// pow = 5, now pow = 5 = 0101 ab power ko target krte hue solve krne ka hai rey biddu
// ab yahaan kya hua hai - power ko convert krdia binary main toh basically 3 ki power
// 0101 hogyi ab condition set krdi hai pow pr hi, agar power ki least significant bit 
// 1 hai toh ans ko base se multiply krdo, ab base ko square krdo and power ko side by side 
// right shift krte rho until pow doesn't stay more than 0 and finally answer return krdo
// Ab system se dekho 0101 -> 010 -> 01 -> 0 toh basically 4 iterations and uske saath saath
// for 0101, ans = 1*3 = 3 and base = 3*3 = 9, uske baad for 010, ans stays 3 but base = 9*9 = 81, 
// uske baad for 01, ans = 3*81 = 243 and base = 81*81 = 6561, uske baad for 0, ans stays 243 but base 
// = 6561*6561 = 43046721 and finally ans = 243 return ho jayega...