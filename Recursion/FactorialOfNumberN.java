public class FactorialOfNumberN {
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }else{
            return n*fact(n-1);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("\nFactorial of " + n + " is - " + fact(n) + "\n");
    }
}

// Space and time complexity dono O(n) hogi