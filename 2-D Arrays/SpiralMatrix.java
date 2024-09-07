public class SpiralMatrix {
    public static void spiralPrint(int[][] matrix){
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;

        while(startRow <= endRow && startColumn <= endColumn){
            // Top
            for(int j = startColumn; j <= endColumn; j++){
                System.out.print(matrix[startRow][j] + " ");
            }

            // Right
            for(int i = startRow+1; i <= endRow; i++){
                System.out.print(matrix[i][endColumn] + " ");
            }

            // Bottom
            for(int j = endColumn-1; j >= startColumn; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // Left
            for(int i = endRow-1; i > startRow; i--){
                if(startColumn == endColumn){
                    break;
                }
                System.out.print(matrix[i][startColumn] + " ");
            }

            startColumn++;
            endColumn--;
            startRow++;
            endRow--;
        }
    }
    public static void main(String args[]){
        int[][] matrix = {{1,2,3,4}, 
        {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println("\nSpiral Matrix - ");
        spiralPrint(matrix);
        System.out.println("\n");
    }
}