public class XToThePowerN {
    public static int power(int x, int n){
        if (n == 0) {
            return 1;
        }else{
            return x * power(x, n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println("\n" + power(2, 10) + "\n");
    }
}