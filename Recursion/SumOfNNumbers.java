public class SumOfNNumbers {
    public static int sumN(int n){
        if(n == 1){
            return n;
        }else{
            return n + sumN(n-1);
        }
    }
    public static void main(String args[]){
        int n = 10;
        System.out.println("\nSum of first " + n + " Natural Numbers is - " + sumN(n) + "\n");
    }
}