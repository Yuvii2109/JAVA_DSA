// MST - Minimum Spanning Tree -> Also called minimum weight spanning tree is a subset of edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
// 1. We can use it to find the shortest path between two nodes in a graph.
// 2. We can use it to find the minimum cost of connecting all nodes in a graph

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
             (0)
            / | \
         10/  |15\30
          /   |   \
        (1)  (2)  (3)
          \   |___//
         40\   50 /
            \____/
        */

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int vertex, cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(this.cost, p2.cost);
        }
    }

    static void prims(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] key = new int[V]; // Stores min cost to reach each vertex
        int[] parent = new int[V]; // Stores parent of each vertex in MST

        // Initialize all keys with a large value
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        pq.add(new Pair(0, 0)); // Start with vertex 0
        key[0] = 0; // Key of source vertex is 0

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            for (Edge edge : graph[u]) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Pair(v, weight));
                    parent[v] = u;
                }
            }
        }

        int finalCost = 0;
        for (int i = 1; i < V; i++) {
            finalCost += key[i];
        }

        System.out.println("Final(Min) cost of MST - " + finalCost);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices = 4; // Corrected to 4, as per the graph
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        prims(graph);
    }
}

// Time complexity - O(E*logV)