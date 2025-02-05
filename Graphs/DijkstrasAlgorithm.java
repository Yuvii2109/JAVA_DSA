// Shortest path from source to all the vertices. (Weighted graph)
// Dijkstra’s algorithm is used for finding the shortest path in a graph where the edges have non-negative weights. The idea is to - Start from the source vertex and initialize the distances to all other vertices as infinity (Integer.MAX_VALUE), except the source itself, which is set to 0. Use a priority queue (Min-Heap) to always expand the node with the smallest known distance. Update the distances of all neighboring vertices if a shorter path is found. Continue this process until all vertices have been processed.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    public static class Edge{
        int source, destination, weight;
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
             2/     \4
             ↙       ↘
           (1)---1-->(2)
            |         |
           7|         |3
            ↓    2    ↓
            (3)<-----(4)
             \       /
             1\     /5
               ↘   ↙
                (5)
        */

        // Vertex - 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // Vertex - 1
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // Vertex - 2
        graph[2].add(new Edge(2, 4, 3));

        // Vertex - 3
        graph[3].add(new Edge(3, 5, 1));

        // Vertex - 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    public static class Pairs implements Comparable<Pairs>{
        // Pairs stores a vertex and its current shortest distance from the source. It implements Comparable<Pairs> to enable priority queue sorting based on distance.
        int vertex, distance;
        public Pairs(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pairs path) {
            return Integer.compare(this.distance, path.distance); // path based sorting for the pairs
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int source){
        int n = graph.length;
        int[] pathLength = new int[n]; // pathLength[i] = source -> i
        for(int i = 0; i < graph.length; i++){
            if(i != source){
                pathLength[i] = Integer.MAX_VALUE;
            }
        }
        // pathLength[i] stores the shortest distance from source to vertex i. Initially, all distances are set to infinity (Integer.MAX_VALUE), except source, which is set to 0.

        boolean[] visited = new boolean[n];
        PriorityQueue<Pairs> pq = new PriorityQueue<>();
        pq.add(new Pairs(source, 0)); // add source to priority queue
        /*
            visited[] Array Initialization -
            Purpose - Keeps track of whether a vertex has been processed (i.e., its shortest path has been finalized). Initially, all values are false because no vertex has been visited yet.

            Priority Queue (pq) Initialization -
            PriorityQueue<Pairs> - Used to always expand the node with the smallest known distance. Pairs (vertex, distance) are stored, where - vertex is the node number, distance is the current shortest distance from the source.

            Add Source Vertex -
            The source vertex is inserted into the priority queue with a distance of 0 because the distance from itself is always 0.
        */

        while(!pq.isEmpty()){
            Pairs current = pq.remove();
            int u = current.vertex;
            // Remove the vertex with the shortest known distance from pq. This ensures that we always process the closest vertex first.  Greedy Choice - This is why Dijkstra's Algorithm is greedy—it picks the nearest unprocessed node at each step. Extract the vertex number (u) from the Pairs object. u is the current vertex being processed.

            if(!visited[u]){ //Because once a vertex is visited, its shortest distance is finalized, and processing it again is unnecessary.
                visited[u] = true; // Indicating the shortest path to u has been confirmed and won't be processed again
                for(Edge e : graph[u]){
                    int neighbor = e.destination;
                    int weight = e.weight;
                    if(!visited[neighbor] && pathLength[neighbor] > pathLength[u] + weight){
                        // If current known shortest path (pathLength[v]) is greater than the new possible shorter path (pathLength[u] + weight), then - Update pathLength[v] to the new, shorter distance. Push v into the priority queue with its updated distance.
                        pathLength[neighbor] = pathLength[u] + weight;
                        pq.add(new Pairs(neighbor, pathLength[neighbor]));
                    }
                }
            }
        }
        // print the shortest distances from source to all other vertices   
        for(int i = 0; i < n; i++){
            System.out.println("Vertex " + i + " is at a distance of " + pathLength[i]);
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0);
    }
}

// Time complexity - O(V + ElogV)

/*
    Initialization -
        pathLength[] - Stores the shortest distance from source (0). 
        pathLength = [0, ∞, ∞, ∞, ∞, ∞]
        visited[] - Tracks processed vertices.
        visited = [false, false, false, false, false, false]
        Priority Queue (Min-Heap) is initialized and source (0) is added with distance 0 - pq = [(0, 0)]

    Execution Loop (Processing the Queue) -

    Iteration 1 - Process Node 0
        Remove (0, 0) from pq.
        Mark 0 as visited.
        Update neighbors -
        1 → 2 (update pathLength ∞ → 2, add (1,2) to pq)
        2 → 4 (update pathLength ∞ → 4, add (2,4) to pq)
        Updated Arrays - pathLength = [0, 2, 4, ∞, ∞, ∞]
        visited = [true, false, false, false, false, false]
        pq = [(1, 2), (2, 4)]

    Iteration 2 - Process Node 1 (Smallest in pq)
        Remove (1, 2) from pq.
        Mark 1 as visited.
        Update neighbors -
        2 → 3 (2+1, update 4 → 3, add (2,3) to pq)
        3 → 9 (2+7, update ∞ → 9, add (3,9) to pq)
        Updated Arrays - pathLength = [0, 2, 3, 9, ∞, ∞]
        visited = [true, true, false, false, false, false]
        pq = [(2, 3), (2, 4), (3, 9)]

    Iteration 3 - Process Node 2 (Smallest in pq)
        Remove (2, 3) from pq.
        Mark 2 as visited.
        Update neighbors - 4 → 6 (3+3, update ∞ → 6, add (4,6) to pq)
        Updated Arrays - pathLength = [0, 2, 3, 9, 6, ∞]
        visited = [true, true, true, false, false, false]
        pq = [(2, 4), (3, 9), (4, 6)]

    Iteration 4 - Process Node 4 (Smallest in pq)
        Remove (4, 6) from pq.
        Mark 4 as visited.
        Update neighbors - 
        3 → 8 (6+2, update 9 → 8, add (3,8) to pq)
        5 → 11 (6+5, update ∞ → 11, add (5,11) to pq)
        Updated Arrays - pathLength = [0, 2, 3, 8, 6, 11]
        visited = [true, true, true, false, true, false]
        pq = [(3, 8), (3, 9), (5, 11)]

    Iteration 5 - Process Node 3 (Smallest in pq)
        Remove (3, 8) from pq.
        Mark 3 as visited.
        Update neighbors - 5 → 9 (8+1, update 11 → 9, add (5,9) to pq)
        Updated Arrays - pathLength = [0, 2, 3, 8, 6, 9]
        visited = [true, true, true, true, true, false]
        pq = [(3, 9), (5, 11), (5, 9)]

    Iteration 6 - Process Node 3 Again
        Remove (3,9), but skip because 3 is already visited.

    Iteration 7 - Process Node 5 (Smallest in pq)
        Remove (5,9).
        Mark 5 as visited.
        Updated Arrays - pathLength = [0, 2, 3, 8, 6, 9]
        visited = [true, true, true, true, true, true]
        pq = [(5, 11)]

    Iteration 8 - Process Node 5 Again
        Remove (5,11), but skip because 5 is already visited.
*/