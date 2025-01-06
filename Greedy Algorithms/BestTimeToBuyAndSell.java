// Best Time to Buy and Sell Stock -
// Given an array prices[] of length N, representing the prices of the 
// stocks on different days, the task is to find the maximum profit 
// possible for buying and selling the stocks on different days
// using transactions where at most one transaction is allowed.
// Note - Stock must be bought before being sold.
// Sample Input 1 - prices[] = {7, 6, 4, 3, 1}
// Sample Output 1 - 0
// Sample Input 2 - prices[] = {7, 1, 5, 3, 6, 4]
// Sample Output 2 - 5

import java.util.*;

public class BestTimeToBuyAndSell {
    public static int maxProfit(int[] prices) {
        // Initializing variables
        int minPrice = Integer.MAX_VALUE; 
        int maxProfit = 0;

        // Iterate through the array
        for (int price : prices) {
            // Update the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit if selling at the current price
            int profit = price - minPrice;

            // Update the maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        if(maxProfit <= 0){
            System.out.println("Don't buy");
        }else{
            System.out.println("Buy when price of stock is - " + minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices1 = {7, 6, 4, 3, 1};
        int[] prices2 = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum profit - " + maxProfit(prices1)); 
        System.out.println("Maximum profit - " + maxProfit(prices2));
    }
}