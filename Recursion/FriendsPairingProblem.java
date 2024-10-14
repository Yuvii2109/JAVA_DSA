public class FriendsPairingProblem {
    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int single = friendsPairing(n-1);
        int pair = friendsPairing(n-2);
        int pairWays = (n-1)*pair;
        return single + pairWays; // Total number of ways
    }
    public static void main(String[] args) {
        System.out.println(friendsPairing(4)); // Output: 10
    }
}