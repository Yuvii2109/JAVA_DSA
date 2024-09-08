public class Comparison {
    public static void main(String args[]){
        String str1 = "Yuvraj";
        String str2 = "Yuvraj";
        String str3 = new String("Yuvraj");
        if(str1 == str2){
            System.out.println("\nstr1 and str2 are same");
        }else{
            System.out.println("\nstr1 and str2 are not same");
        }
        if(str1 == str3){
            System.out.println("str1 and str3 are same");
        }else{
            System.out.println("str1 and str3 are not same");
        }

        // Explanation 1
        // Basic funda yeh hai ki jb hm String bnate hain or new ka use nahi karte
        // to phir new string or purani string dono ek hi string ko point kr rhi hoti hain
        // toh uss case main agr hm unn dono ko compare karenge using == toh answer 
        // true aayega kyunki dono ek hi object ko point kr rhi h... But jb hmne new ka use krlia
        // toh new string ek alag object ban jati hain isliye unn dono strings ko == iska
        // use karte hue agr hum compare karenge toh answer false aayega kyunki
        // dono alag alag objects hain

        // Explanation 2
        // Toh yaar pehle wale str1, str2 ke comparison main toh 
        // == operator ka use kiya, jiska result true aaya tha
        // Lekin ab str1, str3 ke comparison main == operator ka use kiya
        // hai, jiska result false aaya hai. Iska matlab hai ki str1,
        // str3 dono different objects hain, aur dono different memory locations
        // par stored hain. Isliye == operator ka use karke str1, 
        // str3 ke comparison main false result aaya hai.

        // Isliye use krna chahiye .equals aao btaaoon kaise - 
        if(str1.equals(str3)){
            System.out.println("str1 and str3 are same\n");
        }else{
            System.out.println("str1 and str3 are not same\n");
        }
    }
}