// It's the topological sort using BFS

// A Directed Acyclic Graph has atleast one vertex with in-degree - 0 and one vertex with out-degree 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
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
    public static void calculateIndegree(ArrayList<Edge> graph[], int indegree[]){
        int V = graph.length;
        for(int i = 0; i < V; i++){
            for(Edge edge : graph[i]){
                indegree[edge.destination]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge>[] graph){
        int V = graph.length;
        int[] inDegree = new int[V];
        calculateIndegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");
            for(Edge edge : graph[current]){
                inDegree[edge.destination]--;
                if(inDegree[edge.destination] == 0){
                    q.add(edge.destination);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.print("Topological Sort order - ");
        topSort(graph);
    }
}

// Bhai yaar shayad mai, DFS ke liye right tha BFS ke liye nahi kyuki scheduling problem main order vary kar skta hai... Baat rhi ise output ki toh 4, 5 ke baad 0 isliye aaya hai kyuki 4, 5 traverse krne ke elawa or koi raasta hai hi nahi 0 tak jaane ka...