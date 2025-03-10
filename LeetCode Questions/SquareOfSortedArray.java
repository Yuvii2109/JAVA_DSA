public class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n-1;
        int i = n-1;
        while(left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if(leftSquare > rightSquare){
                result[i] = leftSquare;
                left++;
            }else{
                result[i] = rightSquare;
                right--;
            }
            i--;
        }
        return result;
    }
}