// Find the size of the largest region in the Boolean Matrix - 
// We have a matrix where each cell contains either a ‘0’ or a ‘1’, and  any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. If one or more filled cells are also connected, they form a region. Find the size of the largest region.
// Input - M[][5] = { 
//     {0, 0, 1, 1, 0}, 
//     {0, 0, 1, 1, 0}, 
//     {0, 0, 0, 0, 0}, 
//     {0, 0, 0, 0, 1} 
// }
// Output - 4
// We need to find the size of the largest region (the maximum number of connected 1s in a single group).

public class LargestRegionBooleanMatrix {

    // Define the possible movements - horizontally, vertically, and diagonally
    private static final int[] rowMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colMoves = {-1, 0, 1, -1, 1, -1, 0, 1};
    // For each index i from 0 to 7, the pair (rowMoves[i], colMoves[i]) gives the offset to move from a current cell to one of its eight adjacent neighbors (including diagonals).

    // Helper function to check if a given cell is within bounds, contains '1' and not visited before
    private static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        int rows = M.length;
        int cols = M[0].length;
        return (row >= 0 && row < rows && col >= 0 && col < cols
                && M[row][col] == 1 && !visited[row][col]);
    }
    // int rows = M.length; and int cols = M[0].length; get the number of rows and columns in the matrix. The return statement uses a single compound condition - 
    // row >= 0 && row < rows ensures the row index is valid.
    // col >= 0 && col < cols ensures the column index is valid.
    // M[row][col] == 1 confirms that the cell is filled.
    // !visited[row][col] makes sure we haven't already processed this cell.

    // Recursive method to explore and counts all connected filled cells (cells containing 1) starting from the current cell (row, col).
    private static int DFS(int[][] M, int row, int col, boolean[][] visited) {
        // Mark this cell as visited
        visited[row][col] = true;
        int size = 1; // Initialize size of region to 1
        
        // Check all 8 possible movements from the current cell
        for (int i = 0; i < 8; i++) {
            if (isSafe(M, row + rowMoves[i], col + colMoves[i], visited)) {
                size += DFS(M, row + rowMoves[i], col + colMoves[i], visited);
            }
        }
        
        return size;
    }

    // Iterates over every cell in the matrix, and when it finds an unvisited cell that is filled (1), it uses DFS to calculate the size of the region that cell belongs to.
    public static int largestRegion(int[][] M) {
        int rows = M.length;
        if (rows == 0) return 0;
        int cols = M[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        int maxRegionSize = 0;
        
        // Traverse each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    // If cell contains '1' and is not visited, perform DFS
                    int regionSize = DFS(M, i, j, visited);
                    // Update maxRegionSize if a larger region is found
                    if (regionSize > maxRegionSize) {
                        maxRegionSize = regionSize;
                    }
                }
            }
        }
        
        return maxRegionSize;
    }

    // Main method to test the largestRegion function
    public static void main(String[] args) {
        int[][] M = {
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1}
        };
        
        int largestRegionSize = largestRegion(M);
        System.out.println("Size of the largest region - " + largestRegionSize);
    }
}

// Time Complexity - O(R*C)