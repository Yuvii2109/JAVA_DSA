public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        int low = 0, high = rows - 1;
        while(low <= high){
            int midRow = low + (high-low)/2;
            if(matrix[midRow][0] <= target && matrix[midRow][cols-1] >= target){
                int left = 0, right = cols-1;
                while(left <= right){
                    int midCol = left + (right-left)/2;
                    if(matrix[midRow][midCol] == target){
                        return true; // Found the target
                    }else if(matrix[midRow][midCol] < target){
                        left = midCol+1; // Move right
                    }else{
                        right= midCol-1; // Move left
                    }
                }
                break; // If the target is not found in the current row, break the current row loop
            }else if(matrix[midRow][0] < target){
                low = midRow+1; // Move to lower half
            }else{
                high = midRow-1; // Move to upper half
            }
        }
        return false; // target not found
    }
}