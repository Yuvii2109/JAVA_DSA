public class ProductExceptSelf{
    // Brute Force approach - 
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int product = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    product *= nums[j];
                }
            }
            result[i] = product;
            product = 1;
        }
        return result;
    }
    // Optimal Approach -
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int leftProducts[] = new int[n];
        leftProducts[0] = 1;
        for(int i = 1; i < n; i++){
            leftProducts[i] = nums[i-1]*leftProducts[i-1];
        }
        int rightProduct = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] = leftProducts[i]*rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}