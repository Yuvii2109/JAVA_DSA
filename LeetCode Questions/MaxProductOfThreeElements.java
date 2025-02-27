import java.util.Arrays;

public class MaxProductOfThreeElements {
    public int maximumProductSortedAppraoch(int[] nums) {
        // Dekho yaar the mantra is - 
        // Ya toh 3 largest numbers ka multiple highest hoga ya phir
        // 2 least numbers ka largest number ke saath multiple largest hoga
        Arrays.sort(nums);
        int n = nums.length;
        int possibility1 = nums[n-1] * nums[n-2] * nums[n-3];
        int possibility2 = nums[0] * nums[1] * nums[n-1];
        return Math.max(possibility1, possibility2);
    }
    // Ab dekho yeh code ki time complexity is - O(nlogn)
    // Lets try for O(n)
    public int maximumProduct(int[] nums){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max3 = max2;
                max2 = num;
            }else if(num > max3){
                max3 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num < min2){
                min2 = num;
            }
        }
        return Math.max((max1 * max2 * max3), (min1 * min2 * max1));
    }
}