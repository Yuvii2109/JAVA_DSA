import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        // Brute Force
        for(int i = 0; i < height.size(); i++){
            for(int j = i + 1; j < height.size(); j++){
                int h = Math.min(height.get(i), height.get(j));
                int w = j - i;
                int water = h * w;
                maxWater = Math.max(maxWater, water);
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