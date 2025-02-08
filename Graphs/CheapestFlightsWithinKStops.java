// There are n cities connected by some number of flights. You are given an array flights where flight[i] = [from, to, price] indicates that there is a flight. You are also given 3 integers - source, destination and k, return the cheapest price from source to destination with at most k stops, if there is no such route, return -1.
// Input - flights - [[0, 1, 100], [1, 2, 100], [0, 2, 500]]
//         source - 0, destination - 2, k = 1
// Output - 200

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public static class Edge {
        int from, to, price;

        public Edge(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }

    // Create graph using List of Lists
    public static void createGraph(int[][] flights, List<List<Edge>> graph) {
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            graph.get(from).add(new Edge(from, to, price));
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int source, int destination, int k) {
        // Step 1 - Create graph from flights data
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        createGraph(flights, graph);

        // Step 2 - Initialize distance array to track minimum cost to reach each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Step 3 - Use a priority queue for Dijkstra's algorithm, storing [price, vertex, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, source, 0}); // [price, vertex, stops]

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentPrice = current[0];
            int currentVertex = current[1];
            int currentStops = current[2];

            if (currentVertex == destination) {
                return currentPrice;
            }

            if (currentStops > k) {
                continue;
            }

            // Explore neighbors
            for (Edge edge : graph.get(currentVertex)) {
                int nextVertex = edge.to;
                int nextPrice = edge.price;

                // Check if a cheaper path exists
                if (distance[nextVertex] > currentPrice + nextPrice) {
                    distance[nextVertex] = currentPrice + nextPrice;
                    pq.offer(new int[]{distance[nextVertex], nextVertex, currentStops + 1});
                }
            }
        }
        return -1; // If no valid path is found
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int source = 0, destination = 3, k = 1;

        int cheapestPrice = findCheapestPrice(n, flights, source, destination, k);
        System.out.println("Cheapest price from source " + source +
                           " to destination " + destination +
                           " with at most " + k + " stops - " + cheapestPrice);
    }
}

// Time Complexity - O(k*ElogV)