// Here implement Union-Find Algorithm to check whether an undirected graph contains cycle or not
// Input - 
// 9-------5--------2
//  \     /         |
//   \   /          |
//    \ /           |
//     1            7
// Output - Cycle exists in this graph

import java.util.ArrayList;

public class UnionFindUndirectedCycleDetection {
    public static class Edge {
        int source, destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    // Function to create the graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Adding Edges to the Graph (Undirected Graph)
        graph[1].add(new Edge(1, 9));
        graph[1].add(new Edge(1, 5));
        graph[2].add(new Edge(2, 5));
        graph[2].add(new Edge(2, 7));
        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 9));
        graph[7].add(new Edge(7, 2));
        graph[9].add(new Edge(9, 1));
        graph[9].add(new Edge(9, 5));
    }

    // Find function with Path Compression
    public static int find(int parent[], int v) {
        if (parent[v] == -1) {
            return v;
        }
        return parent[v] = find(parent, parent[v]); // Path compression
    }

    // Union function with Union by Rank
    public static void union(int parent[], int rank[], int v1, int v2) {
        int root1 = find(parent, v1);
        int root2 = find(parent, v2);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    // Function to check if a cycle exists
    public static boolean isCyclic(int vertices, ArrayList<Edge>[] graph) {
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        // Initialize parent array
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }

        // Process all edges
        for (int i = 0; i < vertices; i++) {
            for (Edge edge : graph[i]) {
                int srcParent = find(parent, edge.source);
                int destParent = find(parent, edge.destination);

                // If two vertices have the same root, a cycle exists
                if (srcParent == destParent) {
                    return true;
                }

                // Union the sets
                union(parent, rank, srcParent, destParent);
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices = 10;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        if (isCyclic(vertices, graph)) {
            System.out.println("Cycle exists in this graph");
        } else {
            System.out.println("No Cycle detected");
        }
    }
}

/*
Initialize Disjoint Set (parent[] and rank[]) -
    parent[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
    rank[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    Each node is initially its own parent (set to -1).
    Rank is set to 0 for all nodes.

Process each edge and perform Union-Find 
    (1, 9) → find(1) = 1, find(9) = 9 → Different parents → union(1, 9)
    parent[] = {-1, -1, -1, -1, -1, -1, -1, -1, 1, -1}
    rank[] = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}

    (1, 5) → find(1) = 1, find(5) = 5 → Different parents → union(1, 5)
    parent[] = {-1, -1, -1, -1, -1, 1, -1, -1, 1, -1}
    rank[] = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}

    (2, 5) → find(2) = 2, find(5) = 1 → Different parents → union(2, 5)
    parent[] = {-1, -1, 1, -1, -1, 1, -1, -1, 1, -1}
    rank[] = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}

    (2, 7) → find(2) = 1, find(7) = 7 → Different parents → union(2, 7)
    parent[] = {-1, -1, 1, -1, -1, 1, -1, 1, 1, -1}
    rank[] = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}

    (5, 9) → find(5) = 1, find(9) = 1 → Same parent, Cycle Detected!

Since both find(5) and find(9) return 1, it means they are already connected, forming a cycle.
*/