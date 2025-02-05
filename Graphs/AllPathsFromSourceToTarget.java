import java.util.ArrayList;

public class AllPathsFromSourceToTarget {
    public static class Edge{
        int source, destination;
        public Edge(int source, int destination){
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
         *    ↑        ↑        ↑
         *    |        |        |
         *    |        |        |
         *    5------->0<-------4
         */

        // Vertex - 0
        graph[0].add(new Edge(0, 3));

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
    public static void printAllPath(ArrayList<Edge> graph[], int src, int des, String Path){
        if(src == des){
            System.out.println(Path + des);
            return;
        }
        for(int i = 0; i < graph[src].size(); i++){
            Edge edge = graph[src].get(i);
            printAllPath(graph, edge.destination, des, Path + src + "->");
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 5, des = 1;
        System.out.println("All possible paths are - ");
        printAllPath(graph, src, des, "");
    }
}

/*
    First Call - printAllPath(graph, 5, 1, "");
    src = 5, des = 1, Path = ""
    Vertex 5 has two outgoing edges - (5 → 0), (5 → 2)

    First Recursive Call - printAllPath(graph, 0, 1, "5->");
    Second Recursive Call - printAllPath(graph, 2, 1, "5->");

    Exploring Paths from Vertex 0 - printAllPath(graph, 0, 1, "5->");
    src = 0, des = 1, Path = "5->"
    Vertex 0 has one outgoing edge (0 → 3).

    Next Recursive Call - printAllPath(graph, 3, 1, "5->0->");

    Exploring Paths from Vertex 3 - printAllPath(graph, 3, 1, "5->0->");
    src = 3, des = 1, Path = "5->0->"
    Vertex 3 has one outgoing edge (3 → 1), which reaches the destination - printAllPath(graph, 1, 1, "5->0->3->");
    Base Case Hit - Since src == des, print the path - 5->0->3->1

    Exploring Paths from Vertex 2 - printAllPath(graph, 2, 1, "5->");
    src = 2, des = 1, Path = "5->"
    Vertex 2 has one outgoing edge (2 → 3).
    Next Recursive Call - printAllPath(graph, 3, 1, "5->2->");
    Since we already explored 3 -> 1, this call results in - 5->2->3->1
*/