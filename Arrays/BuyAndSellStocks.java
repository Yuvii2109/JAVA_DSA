public class BuyAndSellStocks {
    public static void BuyandSell(int arr[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < arr.length; i++){
            if(buyPrice < arr[i]){
                int profit = arr[i] - buyPrice; // Today's Profit
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = arr[i];
            }
        }
        System.out.println("\nMaximum profit can be - " + maxProfit + "\n");
    }
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        BuyandSell(prices);
    }
}