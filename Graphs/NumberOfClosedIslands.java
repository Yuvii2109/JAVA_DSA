// We have a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix. A closed island is known as the group of 1s that is surrounded by only 0s on all the four sides (excluding diagonals). If any 1 is at the edges of the given matrix then it is not considered as the part of the connected island as it is not surrounded by all 0's. 
// Sample Input 1 - N = 3, M = 3
// mat[][] = {
//     {1, 0, 0},
//     {0, 1, 0},
//     {0, 0, 1}
// }
// Sample Output 1 - 1
// Sample Input 2 - N = 5, M = 8
// mat[][] = {
//     {0, 0, 0, 0, 0, 0, 0, 1},
//     {0, 1, 1, 1, 1, 0, 0, 1},
//     {0, 1, 0, 1, 0, 0, 0, 1},
//     {0, 1, 1, 1, 1, 0, 1, 0},
//     {0, 0, 0, 0, 0, 0, 0, 1}
// }
// Sample Output 2 - 2

public class NumberOfClosedIslands {

    // A helper DFS function that marks the entire connected component of 1's as visited.
    public static void dfs(int[][] mat, boolean[][] visited, int i, int j, int n, int m) {
        // Check for invalid indices or if already visited or if cell is water (0)
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || mat[i][j] != 1) {
            return;
        }
        visited[i][j] = true; // Mark this cell as visited
        
        // Explore all four directions (up, down, left, right)
        dfs(mat, visited, i - 1, j, n, m);
        dfs(mat, visited, i + 1, j, n, m);
        dfs(mat, visited, i, j - 1, n, m);
        dfs(mat, visited, i, j + 1, n, m);
    }

    // This function returns the count of closed islands.
    public static int countClosedIslands(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;
        
        boolean[][] visited = new boolean[n][m];

        // Step 1 - Flood-fill (mark) all islands connected to the border.
        // Any 1 (land) on the border or connected to a border cell cannot be part of a closed island.
        for (int i = 0; i < n; i++) {
            // Check first and last column in every row
            if (mat[i][0] == 1 && !visited[i][0]) {
                dfs(mat, visited, i, 0, n, m);
            }
            if (mat[i][m - 1] == 1 && !visited[i][m - 1]) {
                dfs(mat, visited, i, m - 1, n, m);
            }
        }
        for (int j = 0; j < m; j++) {
            // Check first and last row in every column
            if (mat[0][j] == 1 && !visited[0][j]) {
                dfs(mat, visited, 0, j, n, m);
            }
            if (mat[n - 1][j] == 1 && !visited[n - 1][j]) {
                dfs(mat, visited, n - 1, j, n, m);
            }
        }

        // Step 2 - Now, count the closed islands (groups of 1's not marked as visited).
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    // Found an unvisited island cell that is not connected to the border,
                    // so its connected component is a closed island.
                    count++;
                    dfs(mat, visited, i, j, n, m);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[][] mat1 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        int closedIslands1 = countClosedIslands(mat1);
        System.out.println("Number of closed islands in Sample Input 1 - " + closedIslands1);
        // Expected output: 1

        // Sample Input 2
        int[][] mat2 = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1}
        };
        int closedIslands2 = countClosedIslands(mat2);
        System.out.println("Number of closed islands in Sample Input 2 - " + closedIslands2);
        // Expected output - 2
    }
}