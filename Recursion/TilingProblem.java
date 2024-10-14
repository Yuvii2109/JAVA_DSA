public class TilingProblem {
    public static int tilingProblem(int n){ 
        // 2 X n is the floor size

        // Base case -
        if(n == 0 || n == 1){
            return 1;
        }    
        // Vertical arrangement - 
        int v = tilingProblem(n-1);
        // Horizontal arrangement -
        int h = tilingProblem(n-2);
        // Total number of ways to tile the floor -
        return v + h;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println("\n" + tilingProblem(n) + " ways to arrange 2 X 1 tiles on a 2 X " + n + " floor\n");
    }
}