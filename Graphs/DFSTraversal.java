import java.util.ArrayList;

public class DFSTraversal {
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
    public static void DFS(ArrayList<Edge>[] graph, int current, boolean visited[]){
        System.out.print(current + " ");
        visited[current] = true;
        for(Edge edge : graph[current]){
            if(!visited[edge.destination]){
                DFS(graph, edge.destination, visited);
            }
        }
        // It starts from a given vertex current. Prints the current vertex. Marks the current vertex as visited (visited[current] = true). Recursively visits all adjacent vertices (destinations of edges from current) that haven't been visited yet.
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited[] = new boolean[vertices];
        System.out.print("DFS - ");
        DFS(graph, 0, visited);
    }
}

/*
    Initial State - 
        Stack - [DFS(0)]
        Visited - [false, false, false, false, false, false, false]
        Processing DFS(0) -> Prints 0 -> Marks 0 as visited.
        Calls DFS(1) (since 0 → 1 exists).

    Stack - [DFS(0), DFS(1)]
        Visited - [true, false, false, false, false, false, false]
        Processing DFS(1) -> Prints 1 -> Marks 1 as visited.
        Calls DFS(3) (since 1 → 3 exists).

    Stack - [DFS(0), DFS(1), DFS(3)]
        Visited - [true, true, false, true, false, false, false]
        Processing DFS(3) -> Prints 3 -> Marks 3 as visited.
        Calls DFS(4) (since 3 → 4 exists).

    Stack - [DFS(0), DFS(1), DFS(3), DFS(4)]
        Visited - [true, true, false, true, true, false, false]
        Processing DFS(4) -> Prints 4 -> Marks 4 as visited.
        Calls DFS(2) (since 4 → 2 exists).

    Stack - [DFS(0), DFS(1), DFS(3), DFS(4), DFS(2)]
        Visited - [true, true, true, true, true, false, false]
        Processing DFS(2) -> Prints 2 -> Marks 2 as visited.
        No unvisited neighbors left, returns.

    Stack - [DFS(0), DFS(1), DFS(3), DFS(4)]
        Visited - [true, true, true, true, true, false, false]
        Back to DFS(4) -> Calls DFS(5) (since 4 → 5 exists).

    Stack - [DFS(0), DFS(1), DFS(3), DFS(4), DFS(5)]
        Visited - [true, true, true, true, true, true, false]
        Processing DFS(5) -> Prints 5 -> Marks 5 as visited.
        Calls DFS(6) (since 5 → 6 exists).

    Stack - [DFS(0), DFS(1), DFS(3), DFS(4), DFS(5), DFS(6)]
        Visited - [true, true, true, true, true, true, true]
        Processing DFS(6) -> Prints 6 -> Marks 6 as visited.
        No unvisited neighbors left, returns.

    Stack - [DFS(0), DFS(1), DFS(3), DFS(4), DFS(5)]
        Visited - [true, true, true, true, true, true, true]
        Returning from all recursive calls
        
    DFS(5) completes → return to DFS(4).
    DFS(4) completes → return to DFS(3).
    DFS(3) completes → return to DFS(1).
    DFS(1) completes → return to DFS(0).
    DFS(0) completes → program terminates.
*/