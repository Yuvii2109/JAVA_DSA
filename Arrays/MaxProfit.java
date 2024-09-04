public class MaxProfit {
    public static void maxProfitMargin(int arr[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < arr.length; i++){
            if(buyPrice < arr[i]){
                int profit = arr[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = arr[i];
            }
        }
        System.out.println("\nMaximum profit is - " + maxProfit + "\n");
    }
    public static void main(String args[]){
        int prices[] = {5,1,8,2,3,5};
        maxProfitMargin(prices);
    }
}