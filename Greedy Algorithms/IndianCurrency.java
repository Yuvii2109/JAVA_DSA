// We are given infinite supple of denominations [1, 2, 5, 10, 20, 50, 100, 200, 500, 2000]
// Find minimum number of coins/notes to make change for a value V
// For V = 121 -> ans = 3 - (100, 20, 1)
// For V = 590 -> ans = 4 - (500, 50, 20, 20)

import java.util.*;

public class IndianCurrency {
    public static void main(String[] args) {
        Integer currency[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        Arrays.sort(currency, Comparator.reverseOrder());
        // reverseOrder() ko call krne ke liye "int" ki jagah "Integer"
        // hona zaroori hai varna won't be possible
        int currencyCount = 0;
        int amount = 432;
        ArrayList<Integer> used = new ArrayList<>();
        for (int i = 0; i < currency.length; i++) {
            while (amount >= currency[i]) {
                amount -= currency[i];
                used.add(currency[i]);
                currencyCount++;
            }
        }
        System.out.println("Minimum number of coins/notes to make change for a value V = " + currencyCount);
        System.out.print("Notes/Coins used - [ ");
        for (int i = 0; i < used.size(); i++) {
            System.out.print(used.get(i) + " ");
        }
        System.out.print("]");
    }
}