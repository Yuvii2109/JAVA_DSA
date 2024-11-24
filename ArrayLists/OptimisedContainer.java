// 2 pointer approach

import java.util.ArrayList;

public class OptimisedContainer {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int left = 0, right = height.size() - 1;
        while(left < right){
            // Calculating water 
            int minHeight = Math.min(height.get(left), height.get(right));
            int width = right - left;
            int water = minHeight * width;
            maxWater = Math.max(maxWater, water);

            // Updating pointer
            if(height.get(left) < height.get(right)){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
    public static void main(String args[]){
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("Maximum water stored is - " + storeWater(height));
    }
}