import java.util.*;

public class StockSpanProblem {
    // Stock span is the maximum number of consecutive days for which the
    // price of the stock was less than or equal to the current day's price.
    // => /---/ Span = currentIndex - previousHighIndex /---/
    public static void stockSpan(int[] stocks, int[] span){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i = 1; i < stocks.length; i++){
            int currentPrice = stocks[i];
            while(!s.isEmpty() && stocks[s.peek()] <= currentPrice){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i + 1;
            }else{
                int previousHigh = s.peek();
                span[i] = i - previousHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stocks.length];
        stockSpan(stocks, span);
        for(int i = 0; i < span.length; i++) {
            System.out.println("Stock price on day " + (i+1) + " has a span of " + span[i]);
        }
    }
}