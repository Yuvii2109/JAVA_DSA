public class UppercaseToLowercase {
    public static void main(String[] args) {
        System.out.println();
        for(char ch = 'A'; ch <= 'Z'; ch++){
            System.out.print((char)(ch | ' '));
        }
        System.out.println("\n");
    }
}

// Yaaro yeh nahi smjha skta sorry... Haha kaisa lga mera mazak? yeh dekho yaar -
// 01000001  (binary of 'A') | 00100000  (binary of ' ')
// --------
// 01100001  (binary result = 97, which is the ASCII of 'a')
// Toh basically ek trick hi hai yaar to solve this question... Aise dimaag main 
// nahi aayegi isliye bta di na tumhare bhai ne tumhe!!!