public class PrintDigitsOfANumberIndividually {
    public static void main(String[] args) {
        int n = 237;
        int temp1 = n;
        int rev = 0;
        while(temp1 != 0){
            int rem = temp1%10;
            rev = rev*10 + rem;
            temp1 /= 10;
        }
        int temp2 = rev;
        while(temp2 != 0){
            int rem = temp2%10;
            System.out.println(rem);
            temp2 /= 10;
        }
    }
}