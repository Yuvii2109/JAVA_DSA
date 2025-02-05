// Topological sorting used only for Directed Acyclic Graphs(DAG). It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order. 

// Topological sorting is a way to order the vertices of a directed graph such that for every directed edge u→v, vertex u comes before vertex v in the ordering. This ordering helps in scenarios where there are dependencies between tasks or nodes, ensuring that all dependencies of a node are resolved before the node itself is processed.

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingUsingDFS {
    public static class Edge{
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        int V = graph.length;
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        /*
         *    2------->3------->1
         *    ↑                 ↑
         *    |                 |
         *    |                 |
         *    5------->0<-------4
         */

        // Vertex - 2
        graph[2].add(new Edge(2, 3));

        // Vertex - 3
        graph[3].add(new Edge(3, 1));

        // Vertex - 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // Vertex - 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void topSort(ArrayList<Edge>[] graph){
        int V = graph.length;
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topSortUtil(graph, i, visited, s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int current, boolean[] visited, Stack<Integer> s){
        visited[current] = true;
        for(Edge e : graph[current]){
            int neighbour = e.destination;
            if(!visited[neighbour]){
                topSortUtil(graph, neighbour, visited, s);
            }
        }
        s.push(current);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        System.out.print("Topological Sort order - ");
        topSort(graph);
    }
}

// Logic - Idk if I'm right or not... but the vertex with most outgoing edges comes first and the vertex with the most incoming edges comes last