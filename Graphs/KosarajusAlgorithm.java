// Strongly Connected Component - 
// SCC is a component in which we can reach every vertex of the component from every other vertex in that component

import java.util.*;

public class KosarajusAlgorithm {
    public static class Edge {
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    
    public static void createGraph(List<ArrayList<Edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            graph.set(i, new ArrayList<>());
        }
        /*
            1
            |↖
            |  \
            ↓   \
            0--->2
            |      
            |
            ↓
            3
            |      
            |
            ↓
            4
        */
        graph.get(0).add(new Edge(0, 2));
        graph.get(0).add(new Edge(0, 3));
        graph.get(1).add(new Edge(1, 0));
        graph.get(2).add(new Edge(2, 1));
        graph.get(3).add(new Edge(3, 4));
    }
    
    public static void topologicalSort(List<ArrayList<Edge>> graph, int current, boolean[] visited, Stack<Integer> s) {
        visited[current] = true;
        for (Edge edge : graph.get(current)) {
            if (!visited[edge.destination]) {
                topologicalSort(graph, edge.destination, visited, s);
            }
        }
        s.push(current);
        // Kosaraju’s Algorithm processes nodes in reverse topological order. The stack ensures that finishing order is preserved.
    }
    
    public static void dfs(List<ArrayList<Edge>> graph, int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (Edge edge : graph.get(current)) {
            if (!visited[edge.destination]) {
                dfs(graph, edge.destination, visited);
            }
        }
        // This DFS is used to discover SCCs in the transposed graph.
    }
    
    public static void kosaraju(List<ArrayList<Edge>> graph, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, stack);
            }
        }
        // The first DFS pass ensures we process nodes in decreasing finish time.
        
        // Creating transpose graph
        List<ArrayList<Edge>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (Edge edge : graph.get(i)) {
                transpose.get(edge.destination).add(new Edge(edge.destination, edge.source));
            }
        }
        // In the transposed graph, SCCs remain strongly connected, making it easier to detect them.
        
        visited = new boolean[V];
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                System.out.print("Strongly Connected Component - ");
                dfs(transpose, current, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        createGraph(graph);
        kosaraju(graph, vertices);
    }
}

// Time complexity - O(V+E)