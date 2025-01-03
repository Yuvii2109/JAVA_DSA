// Given the weights and values of N items, put these items in a knapsack
// of capacity W to get the maximum total value in the knapsack.
// value = [60, 100, 120]
// weight = [10, 20, 30]
// W = 50
// Ans - 240
// Compulsion - saari items daalne ka hai rey baba

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        double ratio[][] = new double[value.length][2];
        for(int i = 0; i < value.length; i++) {
            ratio[i][0] = i; // index
            ratio[i][1] = (double) value[i] / weight[i]; // type casted
        }
        // A ratio 2D array is used to store:
        // ratio[i][0]: Index of the item.
        // ratio[i][1]: Value-to-weight ratio of the item.
        // For example:
        // Item 1: ratio = 6.0, weight = 10, value = 60
        // Item 2: ratio = 5.0, weight = 20, value = 100
        // Item 3: ratio = 4.0, weight = 30, value = 120
        
        // Ascending Order -
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = W;
        double totalValue = 0.0;
        // Sort ascending main nahi descending main chahiye because we want
        // to pick the item with the highest value-to-weight ratio first
        for(int i = (ratio.length - 1); i >= 0; i--){
            int index = (int)ratio[i][0];
            if(capacity >= weight[index]){
                // Input the complete item
                capacity -= weight[index];
                totalValue += value[index];
            }else{
                // Input the fraction of item
                double fraction = ((double)capacity) / weight[index];
                totalValue += (value[index] * fraction);
                capacity = 0;
                break;
            }
        }
        // Iterated over the items in descending order of their 
        // value-to-weight ratio:
        // 1. If the knapsack can hold the entire item -
        // - Deduct the item's weight from the capacity.
        // - Add the item's value to totalValue.
        // 2. If the knapsack cannot hold the entire item -
        // - Take a fraction of the item to fill the remaining capacity.
        // - Add the proportional value to totalValue.
        // - Set the capacity to 0 and exit the loop.
        System.out.println("Maximum Value = " + totalValue);
    }
}

// Time Complexity - O(nlogn)