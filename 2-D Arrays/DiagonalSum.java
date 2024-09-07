public class DiagonalSum {
    public static void diagonalSum(int[][] matrix){
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        int n = matrix.length;
        int l = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < l; j++){
                // Primary Diagonal
                if(i == j){
                    sumDiagonal1 += matrix[i][j];
                }
                // Secondary Diagonal
                if(i + j == n - 1){
                    sumDiagonal2 += matrix[i][j];
                }
            }
        }
        System.out.println("\nSum of Primary Diagonal - " + sumDiagonal1);
        System.out.println("Sum of Secondary Diagonal - " + sumDiagonal2);
    }

    // Dekho bhai yeh toh hogyi Brute Force

    public static void main(String args[]){
        int[][] matrix = {{1,2,3,4}, 
        {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println("\nDiagonal Sum - ");
        diagonalSum(matrix);
        System.out.println();
    }
}