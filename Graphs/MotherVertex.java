// We have a Directed Graph, nd a Mother Vertex in the Graph (if present). A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
// Input - 
//  1------>0------->3--------->4
//   ↖     /
//    \   /
//     \ ↙
//      2
// Output - 0

import java.util.ArrayList;

public class MotherVertex {
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

        // Adding Edges to the Graph
        graph[1].add(new Edge(1, 0));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    // DFS Traversal
    public static void dfs(int v, boolean[] visited, ArrayList<Edge>[] graph) {
        visited[v] = true;
        for (Edge edge : graph[v]) {
            if (!visited[edge.destination]) {
                dfs(edge.destination, visited, graph);
            }
        }
    }

    // Function to find the Mother Vertex
    public static int findMotherVertex(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];
        int lastFinished = -1;

        // Step 1 - Find the last finished vertex using DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                lastFinished = i;  // Keep track of last finished node
            }
        }

        // Step 2 - Check if lastFinished is a Mother Vertex
        visited = new boolean[V];  // Reset visited array
        dfs(lastFinished, visited, graph);

        // If any vertex is not visited, then lastFinished is NOT a mother vertex
        for (boolean v : visited) {
            if (!v) {
                return -1;  // No Mother Vertex
            }
        }

        return lastFinished;  // Mother Vertex Found
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int motherVertex = findMotherVertex(graph, V);
        if (motherVertex != -1) {
            System.out.println("Mother Vertex - " + motherVertex);
        } else {
            System.out.println("No Mother Vertex Found");
        }
    }
}

// Time complexity - O(V + E)

/*
    Initialize Variables -
        visited[] = {false, false, false, false, false}
        lastFinished = -1

    Perform DFS on all vertices - 
        Start DFS from 0
        Visits - {0 → 2 → 1 → 3 → 4}
        lastFinished = 0
        DFS from 1 → Already visited (skip)
        DFS from 2 → Already visited (skip)
        DFS from 3 → Already visited (skip)
        DFS from 4 → Already visited (skip)
        Final lastFinished Value - 0

    Verify if 0 is the Mother Vertex
        Reset visited[] = {false, false, false, false, false}
        Perform DFS from 0 again.
        Visits - {0 → 2 → 1 → 3 → 4}

    All vertices are visited → Mother Vertex Found = 0
*/