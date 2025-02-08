// Helps in calculating the shortest path from source to all vertices just like Dijkstra's Algorithm but also considers negative weighted edges.

// Bellman Ford doesn't work on negative weighted cycles which basically means that Bellman Ford won't work on a cycle jiske edges ka sum negative hoga...

import java.util.ArrayList;

public class BellmanFordAlgorithm {
    public static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        /*
               (0)
              /   \
             /     \
            /       \
          2/         \4
          ↙           ↘
        (1)---(-4)--->(2)
          ↖           /
         -1\         /2
            \       ↙
            (4)   (3)
              ↖___/
                4
         */

        // Vertex - 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // Vertex - 1
        graph[1].add(new Edge(1, 2, -4));

        // Vertex - 2
        graph[2].add(new Edge(2, 3, 2));

        // Vertex - 3
        graph[3].add(new Edge(3, 4, 4));

        // Vertex - 4
        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFord(ArrayList<Edge>[] graph, int source){
        int V = graph.length;
        int[] distance = new int[V];
        for(int i=0; i<V; i++){
            if(i != source){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        // Relaxation Process -
        for(int i = 0; i < V-1; i++){
            for(int j = 0; j < V; j++){
                for(int k = 0; k < graph[j].size(); k++){
                    Edge edge = graph[j].get(k);
                    int u = edge.source;
                    int v = edge.destination;
                    int weight = edge.weight;
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                        distance[v] = distance[u] + weight;
                    }
                }
            }
        }
        // Print -
        for(int i = 0; i < V; i++){
            System.out.print("Vertex " + i + " is at a distance of " + distance[i] + " from Source " + source + "\n");
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int V = 5; // Number of vertices in the graph
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, 0);
    }
}

// Time Complexity - O(V*E)

/*
    From Vertex 0 -
        The edge (0 -> 1, weight 2) updates distance[1] from infinity to 0 + 2 = 2.
        The edge (0 -> 2, weight 4) updates distance[2] from infinity to 0 + 4 = 4.

    From Vertex 1 -
        The edge (1 -> 2, weight -4) then updates distance[2] from 4 to 2 + (-4) = -2 because 2 was set in the previous step.

    From Vertex 2 -
        The edge (2 -> 3, weight 2) updates distance[3] from infinity to -2 + 2 = 0.

    From Vertex 3 -
        The edge (3 -> 4, weight 4) updates distance[4] from infinity to 0 + 4 = 4.

    From Vertex 4 -
        The edge (4 -> 1, weight -1) is checked but does not update distance[1] because 4 + (-1) = 3 is not less than the current distance[1] which is 2.
*/