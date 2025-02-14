// Bridge is an edge who's deletion increases the graph's number of connected components 
// TARJAN'S ALGORITHM !!!
// 2 Arrays - 
// 1. int discoveryTime[] = new int[V] - Records the time (or order) when a vertex is first visited during DFS.
// 2. int lowestDiscoveryTime[] = new int[V] - Keeps track of the smallest discovery time reachable from a vertex (including itself and through its descendants via back edges).

import java.util.List;
import java.util.ArrayList;

public class BridgeInGraph {
    public static class Edge{
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(List<List<Edge>> graph){
        for(int i = 0; i < graph.size(); i++){
            graph.set(i, new ArrayList<>());
        }        
        /*
               1-----0------3-----5
               |    /       |    /
               |   /        |   /
               |  /         |  /
               | /          | /
                2            4
        */
        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 2));
        graph.get(0).add(new Edge(0, 3));
        graph.get(1).add(new Edge(1, 2));
        graph.get(1).add(new Edge(1, 0));
        graph.get(2).add(new Edge(2, 0));
        graph.get(2).add(new Edge(2, 1));
        graph.get(3).add(new Edge(3, 4));
        graph.get(3).add(new Edge(3, 5));
        graph.get(3).add(new Edge(3, 0));
        graph.get(4).add(new Edge(4, 3));
        graph.get(4).add(new Edge(4, 5));
        graph.get(5).add(new Edge(5, 3));
        graph.get(5).add(new Edge(5, 4));
    }
    public static void dfs(List<List<Edge>> graph, int current, int parent, boolean[] vis, int[] discoveryTime, int[] lowestDiscoveryTime, int time) {
        vis[current] = true;
        discoveryTime[current] = lowestDiscoveryTime[current] = ++time; // We increment the time (this is like a global clock in the DFS) and assign it to both arrays for the current vertex. Note - In a typical implementation, time is maintained globally (or passed as a mutable object) because Java passes primitives by value. Here, each recursive call gets its own copy of time, which is a potential bug. But conceptually, it represents the order in which vertices are visited.

        for(Edge edge : graph.get(current)) {
            if(edge.destination == parent) {
                // Skip the edge leading back to the parent
                continue;
            } else if(!vis[edge.destination]) {
                // Recursively visit unvisited adjacent vertex
                dfs(graph, edge.destination, current, vis, discoveryTime, lowestDiscoveryTime, time);
                
                // After recursion, update the lowest discovery time for current vertex
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], lowestDiscoveryTime[edge.destination]);
                
                // Bridge condition - if no vertex in edge.destination's subtree has a back edge to current or an ancestor of current, then the edge is a bridge.
                if(discoveryTime[current] < lowestDiscoveryTime[edge.destination]) {
                    // This condition means that there is no back edge from the subtree rooted at edge.destination to an ancestor of current. Hence, the edge from current to edge.destination is a bridge.
                    System.out.println("Bridge found between " + current + " and " + edge.destination);
                }
            } else {
                // If the adjacent vertex is already visited and it's not the parent, it is a back edge. Update the lowest discovery time.
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], discoveryTime[edge.destination]);
            }
        }
    }
    public static void tarjanBridge(List<List<Edge>> graph, int V){
        int[] discoveryTime = new int[V];
        int[] lowestDiscoveryTime = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(graph, i, -1, visited, discoveryTime, lowestDiscoveryTime, time);
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        createGraph(graph);
        tarjanBridge(graph, V);
    }
}