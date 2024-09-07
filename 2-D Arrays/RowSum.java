public class RowSum {
    public static void main(String args[]){
        int[][] matrix = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[1][i];
        }
        System.out.println("\nSum of the elements of the second row - " + sum + "\n");
    }   
}