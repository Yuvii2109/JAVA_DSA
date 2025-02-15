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

// Time complexity - O(V+E)

/*
    DFS at Vertex 0 (Initial Call)
        Entry - Called as dfs(graph, 0, -1, visited, discoveryTime, lowestDiscoveryTime, time).
        Actions at Vertex 0 -
            Marks vertex 0 as visited - vis[0] = true;
        Increments time (from 0 to 1) and sets - 
            discoveryTime[0] = lowestDiscoveryTime[0] = 1;
        Iterates over each neighbor of vertex 0 - 
            Neighbor 1 -
                Since 1 is not the parent (parent is -1) and not visited, DFS is called recursively - 
                    dfs(graph, 1, 0, vis, discoveryTime, lowestDiscoveryTime, time);

    DFS at Vertex 1 (Called from Vertex 0)
        Entry - Called as dfs(graph, 1, 0, visited, discoveryTime, lowestDiscoveryTime, time).
        Actions at Vertex 1 - 
            Marks vertex 1 as visited.
        Increments time (from 1 to 2) and sets - 
            discoveryTime[1] = lowestDiscoveryTime[1] = 2;
        Iterates over each neighbor of vertex 1 - 
            Neighbor 2 - 
                Not the parent (parent is 0) and not visited → recursively calls DFS -
                    dfs(graph, 2, 1, vis, discoveryTime, lowestDiscoveryTime, time);

    DFS at Vertex 2 (Called from Vertex 1)
    Entry - Called as dfs(graph, 2, 1, visited, discoveryTime, lowestDiscoveryTime, time).
    Actions at Vertex 2 - 
        Marks vertex 2 as visited.
    Increments time (from 2 to 3) and sets - 
        discoveryTime[2] = lowestDiscoveryTime[2] = 3;
    Iterates over each neighbor of vertex 2 -
        Neighbor 0 - 
            Vertex 0 is not the parent (parent is 1) and is already visited.
            A back edge is found so update - 
                lowestDiscoveryTime[2] = min(3, discoveryTime[0]) = min(3, 1) = 1;
        Neighbor 1 - 
            This equals the parent (1), so it is skipped.
            Return from DFS at Vertex 2 - 
                DFS for vertex 2 finishes and returns to the call at vertex 1.
            Back to DFS at Vertex 1 (Resuming)
            Post DFS at Vertex 2 - 
                Updates - 
                    lowestDiscoveryTime[1] = min(lowestDiscoveryTime[1], lowestDiscoveryTime[2]) = min(2, 1) = 1;

        Next Neighbor of Vertex 1 - 
            Neighbor 0 - 
                This equals the parent (of vertex 1, which is 0) → skipped.
                Return from DFS at Vertex 1 - 
                    DFS for vertex 1 finishes and returns to the call at vertex 0.
                Back to DFS at Vertex 0 (Resuming)
                Post DFS at Vertex 1 - 
                    Updates - 
                        lowestDiscoveryTime[0] = min(lowestDiscoveryTime[0], lowestDiscoveryTime[1]) = min(1, 1) = 1;

        Next Neighbor of Vertex 0 - 
            Neighbor 2 - 
                Vertex 2 is already visited (and is not the parent) → update - 
                    lowestDiscoveryTime[0] = min(1, discoveryTime[2]) = min(1, 3) = 1;
                Next Neighbor of Vertex 0 - 

        Neighbor 3 - 
            Not the parent and not visited → call DFS -
                dfs(graph, 3, 0, vis, discoveryTime, lowestDiscoveryTime, time);
            DFS at Vertex 3 (Called from Vertex 0)
                Entry - Called as dfs(graph, 3, 0, visited, discoveryTime, lowestDiscoveryTime, time).
            Actions at Vertex 3 - 
                Marks vertex 3 as visited.
            Increments time (say, from 3 to 4) and sets - 
                discoveryTime[3] = lowestDiscoveryTime[3] = 4;
            Iterates over each neighbor of vertex 3 -

        Neighbor 4 - 
            Not the parent (parent is 0) and not visited → recursively calls DFS -
                dfs(graph, 4, 3, vis, discoveryTime, lowestDiscoveryTime, time);
            DFS at Vertex 4 (Called from Vertex 3)
                Entry - Called as dfs(graph, 4, 3, visited, discoveryTime, lowestDiscoveryTime, time).
                Actions at Vertex 4 - 
                    Marks vertex 4 as visited.
                Increments time (say, to 5) and sets - 
                    discoveryTime[4] = lowestDiscoveryTime[4] = 5;
                Iterates over each neighbor of vertex 4 - 

        Neighbor 3 - 
            Equals the parent (3) → skipped.

        Neighbor 5 - 
            Not visited → call DFS - 
                dfs(graph, 5, 4, vis, discoveryTime, lowestDiscoveryTime, time);
            DFS at Vertex 5 (Called from Vertex 4)
                Entry - 
                    Called as dfs(graph, 5, 4, visited, discoveryTime, lowestDiscoveryTime, time).
                Actions at Vertex 5 - 
                    Marks vertex 5 as visited.
                Increments time (say, to 6) and sets -
                    discoveryTime[5] = lowestDiscoveryTime[5] = 6;
            Iterates over each neighbor of vertex 5 - 

        Neighbor 3 - 
            Vertex 3 is visited and is not the parent → update - 
                lowestDiscoveryTime[5] = min(lowestDiscoveryTime[5], discoveryTime[3]) = min(6, 4) = 4;

        Neighbor 4:
            Equals the parent (4) → skipped.

        Return from DFS at Vertex 5 - 
            DFS for vertex 5 finishes and returns to the call at vertex 4.
            Back to DFS at Vertex 4 (Resuming)
            After DFS on Vertex 5 -
                Update -
                    lowestDiscoveryTime[4] = min(lowestDiscoveryTime[4], lowestDiscoveryTime[5]) = min(5, 4) = 4;

        DFS at Vertex 4 Completes - 
            Returns control to DFS at vertex 3.
            Back to DFS at Vertex 3 (Resuming)
            Continuing Iteration in Vertex 3 - 
                After processing neighbor 4, update -
                    lowestDiscoveryTime[3] = min(lowestDiscoveryTime[3], lowestDiscoveryTime[4]) = min(4, 4) = 4;

        Neighbor 5 - 
            Already visited → update -
                lowestDiscoveryTime[3] = min(lowestDiscoveryTime[3], discoveryTime[5]) = min(4, 6) = 4;

        Neighbor 0 - 
            Equals the parent (0) → skipped.
            DFS at Vertex 3 Completes - 
                Returns control to DFS at vertex 0.
                Back to DFS at Vertex 0 (Final Steps)
                After DFS on Vertex 3 - 
                    Update - 
                        lowestDiscoveryTime[0] = min(lowestDiscoveryTime[0], lowestDiscoveryTime[3]) = min(1, 4) = 1;
                    Bridge Check at Vertex 0 - 

    For each neighbor reached via recursion, the code checks - 
        if (discoveryTime[current] < lowestDiscoveryTime[edge.destination])
    
    For the edge from vertex 0 to vertex 3 - 
        discoveryTime[0] is 1 and lowestDiscoveryTime[3] is 4.
        Since 1 < 4, the edge (0, 3) is identified as a bridge, and the message is printed - Bridge found between 0 and 3
    
    DFS for Vertex 0 Completes - All neighbors of vertex 0 have been processed.
*/