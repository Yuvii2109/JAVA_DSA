// A Bipartite graph is a graph whose vertices can be divided into two independent sets - A and B such that every edge - (a, b) either connects to a vertex from A to B or a vertex from B to A. In other words, for every edge - either a belongs to A and b belongs to B or a belongs to B or b belongs to A. We can also say that there is no edge that connects vertices of the same set.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static class Edge{
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i = 0; i < col.length; i++){
            col[i] = -1; // Initialise with no colour 
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0; // Assigning 0 to first node - Yellow
                while(!q.isEmpty()){
                    int current = q.poll();
                    for(Edge e : graph[current]){
                        if(col[e.destination] == -1){
                            q.add(e.destination);
                            col[e.destination] = 1 - col[current]; // Assigning opposite colour - Blue
                        }else if(col[e.destination] == col[current]){
                            return false; // If the colour of adjacent node is same, then it is not bipart
                        }
                    }
                }
            }
        }
        return true; // If all nodes are coloured, then it is bipartite
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        int n = graph.length;
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        /*
         *        0-----2
         *       /     /
         *      /     /
         *     1     4    
         *      \   /
         *       \ /
         *        3
         * 
         * By default agar cyclic graph nahi hai toh bipartite hota hi hai vaise toh... khair since yeh graph cyclic hai toh false dega return
         */

        // Vertex - 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // Vertex - 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // Vertex - 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // Vertex - 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // Vertex - 4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int vertices = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        if (isBipartite(graph)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}

// Cheat code btata hoon ek - 
// Acyclic graphs and graphs with even length ki cycle are bipartitie, while the graphs with odd length ki cycle are not bipartite (Basically a cycle with 4 vertices is even length ki cycle while the cycle with 5 vertices is odd length ki cycle)