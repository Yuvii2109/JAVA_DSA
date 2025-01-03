// Given are N ropes of different lengths, the task is to connect 
// these ropes into one rope with minimum cost, such that the cost 
// to connect two ropes is equal to the sum of their lengths.
// Sample Input 1 : N = 4, arr = [4 3 2 6]
// Sample Output 1 : 29
// Logic - 2+3 = Rs. 5 -> [4 5 6]
//         5+4 = Rs. 9 -> [6 9]
//         9+6 = Rs. 15 -> [15]
// Total = 5+9+15 = 29
// Sample Input 2 : N = 2, arr = [1 2 3]
// Sample Output 2 : 9
// Logic - 1+2 = Rs. 3 -> [3 3]
//         3+3 = Rs. 6 -> [6]
// Total = 3+6 = 9

import java.util.*;

public class NRopesMinimumCost {
    public static int minCost(int n, int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        int total = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            total += sum;
            pq.add(sum);
        }
        return total; 
    }
    public static void main(String[] args) {
        int N = 4;
        int[] arr = {4, 3, 2, 6};
        System.out.println("Minimum cost of connecting - " + minCost(N, arr));
    }
}