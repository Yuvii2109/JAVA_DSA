// An Arraylist nums of size n is beautiful if :-
// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j 
// where 2 * nums.get(k) == nums.get(i) + nums.get(j).
// Given the integer n, return any beautiful arraylist nums of 
// size n. There will be at least one valid answer for the given n.

// Sample Input 1 : n = 4
// Sample Output 1 :  [2,1,4,3]
// Sample Input 2 : n = 5
// Sample Output 2 :  [3,1,2,5,4]
// Constraints :
// 1 <= n <= 1000

import java.util.ArrayList;

public class BeautifulArrayList {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(1); // ans is the arraylist that will eventually store the 
        // Beautiful ArrayList. Start with 1 because any Beautiful ArrayList 
        // for n starts with 1 as the base case.

        for(int i = 2; i <= n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            // A loop runs from i=2 to n. This loop helps build the arraylist 
            // iteratively. In each iteration - A temporary list temp is created 
            // to store the expanded elements for the current size.

            for(Integer e : ans){
                if(2*e <= n){
                    temp.add(2*e);
                }
            }
            // This loop iterates over the current elements in ans.
            // For each element e: Calculate 2×e. If 2×e≤n, add it to the 
            // temporary list temp. This ensures that all even numbers for 
            // the current stage are added to temp.

            for(Integer e : ans){
                if(2*e - 1 <= n){
                    temp.add(2*e - 1);
                }
            }
            // This loop iterates over the current elements in ans again.
            // For each element e: Calculate 2×e−1. If 2×e−1≤n, add it to 
            // the temp list. This ensures that all odd numbers for the 
            // current stage are added to temp.

            ans = temp;
        }
        return ans;
    }
    public static void main(String args[]){
        int n = 5;
    }
}

// Approach -  if we separate odd and even numbers then there is no possibility 
// that even numbers will violate the rule with odd numbers and vice versa.
// Now we have to arrange even and odd numbers in such a way that they do not 
// violate rules with themselves. For doing so, first let's say we have a 
// beautiful ArrayList of size n and we want to make n+1 size of ArrayList
// so what we do is first put all odd numbers that lie within 1 to n+1 and 
// then even(We can do even then odd also). Beautiful ArrayList has the 
// property that if we multiply any number with ArrayList then it still remains 
// beautiful or if we add or subtract any number from Arraylist then also it still 
// remains beautiful. For only obtaining even number from n size ArrayList 
// we do 2*num and for obtaining odd size arraylist we do 2 * n-1.