// A vertex in an undirected connected graph is an articulation point(or cut vertex) if removing it(and edges through it) increases the connected component of the graph.
// Ancestor - A node that was discovered before current node in DFS, is the ancestor of current.

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

    // Inner static class to represent an edge in an undirected graph.
    public static class Edge {
        int source, destination;

        // Constructor for the Edge class.
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    /**
     * Utility method to create the graph.
     * The graph is represented as an adjacency list where each vertex has a list of Edge objects.
     * The graph structure used here is -
     * 
     *      1-------0-------3------4
     *       \     /
     *        \   /
     *         \ /
     *          2
     */
    public static void createGraph(List<List<Edge>> graph) {
        // Initialize each vertex's list.
        for (int i = 0; i < graph.size(); i++) {
            graph.set(i, new ArrayList<>());
        }

        // Adding edges for vertex 0.
        graph.get(0).add(new Edge(0, 1)); // Edge between 0 and 1.
        graph.get(0).add(new Edge(0, 2)); // Edge between 0 and 2.
        graph.get(0).add(new Edge(0, 3)); // Edge between 0 and 3.

        // Adding edges for vertex 1.
        graph.get(1).add(new Edge(1, 0)); // Edge between 1 and 0.
        graph.get(1).add(new Edge(1, 2)); // Edge between 1 and 2.

        // Adding edges for vertex 2.
        graph.get(2).add(new Edge(2, 0)); // Edge between 2 and 0.
        graph.get(2).add(new Edge(2, 1)); // Edge between 2 and 1.

        // Adding edges for vertex 3.
        graph.get(3).add(new Edge(3, 0)); // Edge between 3 and 0.
        graph.get(3).add(new Edge(3, 4)); // Edge between 3 and 4.

        // Adding edge for vertex 4.
        graph.get(4).add(new Edge(4, 3)); // Edge between 4 and 3.
    }

    /**
     * Depth-First Search (DFS) method to find articulation points.
     *
     * graph - The graph represented as an adjacency list.
     * current - The current vertex in the DFS traversal.
     * parent - The parent vertex of the current vertex in the DFS tree.
     * visited - Boolean array to track visited vertices.
     * discoveryTime - Array to store the discovery times of vertices.
     * lowestDiscoveryTime - Array to store the lowest discovery time reachable from the vertex.
     * time - Mutable time counter (as an array of size 1) used to assign discovery times.
     */
    public static void dfs(List<List<Edge>> graph, int current, int parent, boolean[] visited, int[] discoveryTime, int[] lowestDiscoveryTime, int[] time) {
        // Mark the current vertex as visited.
        visited[current] = true;
        // Increase the global time counter and assign the discovery time and lowest reachable time.
        discoveryTime[current] = lowestDiscoveryTime[current] = ++time[0];

        // Count of children in the DFS tree for the current vertex.
        int childCount = 0;

        // Iterate through all neighbors (adjacent vertices) of the current vertex.
        for (Edge edge : graph.get(current)) {
            int neighbor = edge.destination;

            // If the neighbor is the parent of the current vertex, skip it.
            if (neighbor == parent) {
                continue;
            }

            // If the neighbor is already visited, it means we have found a back edge.
            if (visited[neighbor]) {
                // Update the lowest discovery time for the current vertex.
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], discoveryTime[neighbor]);
            } else {
                // If the neighbor is not visited, perform DFS recursively.
                dfs(graph, neighbor, current, visited, discoveryTime, lowestDiscoveryTime, time);
                childCount++; // Increment the child count for the current vertex.

                // After returning from DFS, update the lowest discovery time for the current vertex.
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], lowestDiscoveryTime[neighbor]);

                /* 
                   Check if the current vertex is an articulation point -
                   1. If the current vertex is the root (parent == -1) and has more than one child.
                   2. If the current vertex is not the root and the lowest discovery time of the neighbor 
                      is greater than or equal to the discovery time of the current vertex.
                */
                if ((parent == -1 && childCount > 1) || (parent != -1 && lowestDiscoveryTime[neighbor] >= discoveryTime[current])) {
                    System.out.println("Articulation point - " + current);
                }
            }
        }
    }

    /**
     * Method to initiate DFS traversal to find all articulation points in the graph.
     *
     * graph - The graph represented as an adjacency list.
     * V - The number of vertices in the graph.
     */
    public static void getArticulationPoint(List<List<Edge>> graph, int V) {
        // Arrays to store the discovery time and the lowest reachable discovery time for each vertex.
        int[] discoveryTime = new int[V];
        int[] lowestDiscoveryTime = new int[V];
        // Array to keep track of visited vertices.
        boolean[] visited = new boolean[V];

        // Using an array of one element to have a mutable time counter across recursive calls.
        int[] time = new int[1]; // Initially, time[0] = 0

        // Start DFS from each unvisited vertex (covers disconnected graphs, if any).
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, visited, discoveryTime, lowestDiscoveryTime, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph.
        // Initialize the graph as a list of lists.
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        // Build the graph by adding edges.
        createGraph(graph);
        // Find and print all articulation points in the graph.
        getArticulationPoint(graph, V);
    }
}

// Time complexity - O(V+E)