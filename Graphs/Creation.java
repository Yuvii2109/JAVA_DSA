import java.util.*;

public class Creation {
    /*
     *         0        (2)
     *          \     2-----4
     *        (5)\(1)/ \(1)
     *            \ /   \
     *             1-----3
     *               (3)
     */
    public static class Edge {
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList();
        }

        // Add edges to the graph
        // Vertex - 0
        graph[0].add(new Edge(0, 1, 5));
        // Vertex - 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // Vertex - 2
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 1, 1));
        // Vertex - 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // Vertex - 4
        graph[4].add(new Edge(4, 2, 2));

        // Finding Neighbours - 
        System.out.print("Neighbours of 1 are - ");
        for (Edge edge : graph[1]) {
            System.out.print(edge.destination + " ");
        }
        System.out.println();
        System.out.print("Neighbours of 2 are - ");
        for (Edge edge : graph[2]) {
            System.out.print(edge.destination + " ");
        }
        System.out.println();
    }
}