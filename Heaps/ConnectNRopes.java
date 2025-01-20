// Given are N ropes of different lengths, the task is to connect these
// ropes together in such a way that the total cost is minimized. The
// cost of connecting two ropes is equal to the sum of their lengths.

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String args[]){
        int ropes[] = {5, 7, 3, 1, 6};
        int n = ropes.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(ropes[i]);
        }
        int cost = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        System.out.println("Minimum cost of connecting "+ n + " ropes - " + cost);
    }
}