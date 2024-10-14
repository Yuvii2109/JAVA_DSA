public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String source, String helper ,String destination){
        if(n==1){
            System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
            return;
        }
        // Transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n-1, source, destination, helper);
        // Transfer nth from src to dest
        System.out.println("Transfer disk " + n + " from " + source + " to " + destination);
        // Transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n-1, helper, source, destination);
    }
    public static void main(String args[]){
        int n = 3;
        towerOfHanoi(n, "S", "H", "D");
    }
}

// Trick - Khaali ko destination bnana hai... 
// Iski time complexity is O(2^n - 1) ~ O(2^n)