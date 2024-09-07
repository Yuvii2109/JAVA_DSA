public class DiagonalOptimized {
    public static void diagonalSum(int[][] matrix){
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // Primary Diagonal
            sumDiagonal1 += matrix[i][i];

            // Secondary Diagonal -> "i + j = n - 1 => j = n - i - 1"
            sumDiagonal2 += matrix[i][n-i-1];
        }
        System.out.println("\nSum of Primary Diagonal - " + sumDiagonal1);
        System.out.println("Sum of Secondary Diagonal - " + sumDiagonal2);
    }
    public static void main(String args[]){
        int[][] matrix = {{1,2,3,4}, 
        {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println("\nDiagonal Sum - ");
        diagonalSum(matrix);
        System.out.println();
    }
}