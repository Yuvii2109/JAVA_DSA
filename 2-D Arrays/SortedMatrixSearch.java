public class SortedMatrixSearch {
    public static boolean staircaseSearch(int[][] matrix, int key){
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if(matrix[row][col] == key) {
                System.out.println("\nFound key at - [" + row + "][" + col + "]\n");
                return true;
            }else if(key < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("\nKey not found in the matrix\n");
        return false;
    }
    public static void main(String args[]){
        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, 
        {27, 29, 37, 48}, {32, 33, 39, 50}};
        int target = 33;
        staircaseSearch(matrix, target);
    }
}

// Dekh bhai iss question ko krne ki 4 approaches ho skti hai 
// 1. Staircase search jo hmne kra hua hai upr - O(n+m)
// 2. Binary search jo hoga - O(nlogn)
// 3. Hashing jo hoga - O(n)
// 4. Brute Force - O(n^2)
// Hashing baad main krege