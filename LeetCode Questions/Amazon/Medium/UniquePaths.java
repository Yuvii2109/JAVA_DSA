// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

public class UniquePaths {
    /*
        public int factorial(int num){
            // Permuations ka use kiya jaa skta hai... so we have to make use of (n-1)Downs and (m-1)Rights. So total (n+m-2) moves. Now the number of arrangements that can be made with (n+m-2) items is (n+m-2)!/(n-1)!*(m-1)! ab yeh isliye kiya. Let the n be 3 and m be 3 as well... now => we have toh arrange 2 Downs and 2 Rights in 4 places... so we have 4!/2!*2! = 24/4 = 6 as DDRR is an approach. Or agr hme permutations ke basics aate hain toh we'll know that 2 same elements can be arranged in 2!/2! = 1 way... so we have to divide (n+m-2)! by (n-1)!*(m-1)! to get the number of ways to reach from (0,0) to (n-1,m-1) in an n x m grid, where we can move either right or down. So we have to make use of permutation to get the answer in O(n+m) time complexity.
            if(num == 0){
                return 1;
            }else{
                return num*factorial(num-1);
            }
        }
        public int uniquePaths(int m, int n) {
            return factorial(m+n-2)/(factorial(m-1)*factorial(n-1));
        }
    */
    // Aaj ka din hi thoda aisa hai yaar... let's write the code which can perform calculations for very high factorials...
    public int uniquePaths(int m, int n) {
        // Using the combinations is a better approach than using permuations 
        int N = m+n-2;
        int R = Math.min((m-1), (n-1));
        long result = 1; // long using to prevent overflow
        for(int i = 1; i <= R; i++){
            result = result*(N-i+1)/i; // NCR = ((N)*(N-1)*...(N-R+1))/R!
            // Example - 4C3 = 4*3*2/3*2*1
        }
        return (int)result;
    }
}