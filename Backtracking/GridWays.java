// To find the number of ways to reach from (0,0) to (N-1, M-1) 
// in an N x M grid, where we can move either right or down.

public class GridWays {
    public static int gridWays(int i, int j, int n, int m){
        // Base cases
        if (i == n - 1 && j == m - 1) {
            // Condition for last cell
            return 1;
        }else if(i == n || j == m){
            // Condition for boundary cross
            return 0;
        }
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }
    public static void main(String args[]){
        System.out.println(gridWays(0, 0, 3, 3));
    }
}

// Sbse kharab time complexity hai bhai - O(2^(n+m))
// Ab itni gndi time complexity toh dukh dard or peedha hi degi 
// Toh agr optimised approach lena chahen toh uske liye permutation
// ka use kiya jaa skta hai... so we have to make use of (n-1)Downs and
// (m-1)Rights. So total (n+m-2) moves. Now the number of arrangements that 
// can be made with (n+m-2) items is (n+m-2)!/(n-1)!*(m-1)! ab yeh isliye kiya
// Let the n be 3 and m be 3 as well... now => we have toh arrange 2 Downs and 
// 2 Rights in 4 places... so we have 4!/2!*2! = 24/4 = 6 as DDRR is an approach 
// Or agr hme permutations ke basics aate hain toh we'll know that 2 same elements
// can be arranged in 2!/2! = 1 way... so we have to divide (n+m-2)! by (n-1)!*(m-1)! to get
// the number of ways to reach from (0,0) to (n-1,m-1) in an n x m grid, where we can move either right or down.
// So we have to make use of permutation to get the answer in O(n+m) time complexity