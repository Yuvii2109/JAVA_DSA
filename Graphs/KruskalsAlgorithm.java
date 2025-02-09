import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {
    public static class Edge implements Comparable<Edge>{
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    public static int n = 4; // Vertices
    public static int parent[] = new int[n];
    public static int rank[] = new int[n];
    public static void makeSet(){
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if (rank[x] < rank[y]) {
            parent[x] = y;
        }else if (rank[x] > rank[y]) {
            parent[y] = x;
        }else{
            parent[y] = x;
        }
        rank[x]++;
    }
    public static void kruskalsAlgorithm(ArrayList<Edge> edges, int V){
        makeSet();
        Collections.sort(edges);
        int finalCost = 0;
        int count = 0;
        for(int i = 0; count < V-1; i++){
            Edge edge = edges.get(i);
            int x = find(edge.source);
            int y = find(edge.destination);
            if (x != y) {
                // If x == y => Cycle condition
                finalCost += edge.weight;
                union(edge.source, edge.destination);
                count++;
            }
        }
        System.out.println("Cost of MST - " + finalCost);
    }
    // For each edge - It uses find to get the set representatives (x and y) for the source and destination of the edge.
    // Cycle Check - If x is different from y, it means adding the edge won’t form a cycle. The edge’s weight is added to the total cost. 
    // union(edge.source, edge.destination) merges the two sets.
    // count is incremented to keep track of the number of edges in the MST.

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsAlgorithm(edges, V);
    }
}

// Time complexity - O(V + E*logE)