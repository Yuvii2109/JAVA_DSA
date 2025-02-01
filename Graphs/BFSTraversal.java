import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    public static class Edge{
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        /*
         *       1-------3 
         *      /        |\
         *     /         | \
         *    0          |  5-----6
         *     \         | /
         *      \        |/
         *       2-------4
         */

        // Vertex - 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // Vertex - 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // Vertex - 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // Vertex - 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // Vertex - 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // Vertex - 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // Vertex - 6
        graph[6].add(new Edge(6, 5, 1));
    }
    public static void BFS(ArrayList<Edge>[] graph) { // O(V+E)
        int V = graph.length; // Number of vertices
        boolean visited[] = new boolean[V]; // Array to track visited vertices
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS traversal
    
        q.add(0); // Start BFS from vertex 0
        while(!q.isEmpty()) {
            int current = q.poll(); // Dequeue vertex from front of queue
            if(!visited[current]) {
                System.out.print(current + " "); // Print current vertex
                visited[current] = true; // Mark current vertex as visited
                // Traverse all adjacent vertices of current vertex
                for(int i = 0; i < graph[current].size(); i++) {
                    Edge e = graph[current].get(i); // Get edge object
                    if(!visited[e.destination]) {
                        q.add(e.destination); // Enqueue adjacent vertex if not visited
                    }
                }
                // Iterates through all edges of the current vertex (current), retrieves destination vertices (e.destination), and adds them to the queue if they haven't been visited yet.
            }
        }
    }    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        System.out.print("BFS - ");
        BFS(graph);
    }
}

/*
    Initial State -
        Queue (Q) - [0]
        Visited - [false, false, false, false, false, false, false]

    Step 1 - Dequeue 0
        Queue before dequeuing - [0]
        Processing vertex - 0
        Neighbors of 0 (unvisited) - 1, 2
        Queue after enqueueing neighbors - [1, 2]
        Visited - [true, false, false, false, false, false, false]
        Output - 0

    Step 2 - Dequeue 1
        Queue before dequeuing - [1, 2]
        Processing vertex - 1
        Neighbors of 1 (unvisited) - 3
        Queue after enqueueing neighbors - [2, 3]
        Visited - [true, true, false, false, false, false, false]
        Output - 0 1

    Step 3 - Dequeue 2
        Queue before dequeuing - [2, 3]
        Processing vertex - 2
        Neighbors of 2 (unvisited) - 4
        Queue after enqueueing neighbors - [3, 4]
        Visited - [true, true, true, false, false, false, false]
        Output - 0 1 2

    Step 4 - Dequeue 3
        Queue before dequeuing - [3, 4]
        Processing vertex - 3
        Neighbors of 3 (unvisited) - 5
        Queue after enqueueing neighbors - [4, 5]
        Visited - [true, true, true, true, false, false, false]
        Output - 0 1 2 3

    Step 5 - Dequeue 4
        Queue before dequeuing - [4, 5]
        Processing vertex - 4
        Neighbors of 4 (unvisited): (Only 5, but already in queue)
        Queue remains - [5]
        Visited - [true, true, true, true, true, false, false]
        Output - 0 1 2 3 4

    Step 6 - Dequeue 5
        Queue before dequeuing - [5]
        Processing vertex - 5
        Neighbors of 5 (unvisited) - 6
        Queue after enqueueing neighbors - [6]
        Visited - [true, true, true, true, true, true, false]
        Output - 0 1 2 3 4 5

    Step 7 - Dequeue 6
        Queue before dequeuing - [6]
        Processing vertex - 6
        Neighbors of 6 (unvisited) - None
        Queue after processing - []
        Visited - [true, true, true, true, true, true, true]
        Output - 0 1 2 3 4 5 6
*/