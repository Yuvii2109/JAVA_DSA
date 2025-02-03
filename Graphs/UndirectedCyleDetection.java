import java.util.ArrayList;

public class UndirectedCyleDetection {
    public static class Edge{
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        /*
         *        0-------3
         *       /|       |    
         *      / |       | 
         *     1  |       4
         *      \ |
         *       \|
         *        2
         */

        // Vertex - 0
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // Vertex - 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // Vertex - 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // Vertex - 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // Vertex - 4
        graph[4].add(new Edge(4, 3)); 
    }
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        // This function iterates over all vertices in case the graph is disconnected (i.e., multiple components). It ensures each component of the graph is checked for cycles. Calls a DFS-based recursive helper function detectCycleUtil() for unvisited nodes.
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            // Calls detectCycleUtil(graph, i, visited, -1). The -1 represents the parent node (since i is the root, it has no parent). If detectCycleUtil returns true, a cycle is found.
            if(!visited[i]) {
                if(detectCycleUtil(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int current, boolean visited[], int parent){
        visited[current] = true;
        for(Edge edge : graph[current]) {
            if(!visited[edge.destination]) {
                if(detectCycleUtil(graph, edge.destination, visited, current)) {
                    return true;
                }
            }else if(visited[edge.destination] && edge.destination != parent){
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        if(detectCycle(graph)) {
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph doesn't contain cycle");
        }
    }
}

/*
    Visit 0 -
        Mark visited[0] = true
        Neighbors of 0 - {3, 1, 2}
        Calls detectCycleUtil(graph, 3, visited, 0)

    Visit 3 - 
        Mark visited[3] = true
        Neighbors of 3 - {0, 4}
        0 is already visited but it's the parent (so no cycle detected).
        Calls detectCycleUtil(graph, 4, visited, 3)

    Visit 4 -
        Mark visited[4] = true
        Neighbors of 4 - {3}
        3 is the parent (so no cycle detected).
        Returns false to 3.
        Back to 3, returns false to 0
        Continue DFS from 0
        Calls detectCycleUtil(graph, 1, visited, 0)

    Visit 1 -
        Mark visited[1] = true
        Neighbors of 1 - {0, 2}
        0 is the parent (so no cycle detected).
        Calls detectCycleUtil(graph, 2, visited, 1)

    Visit 2 -
        Mark visited[2] = true
        Neighbors of 2 - {0, 1}
        1 is the parent (so no cycle detected).
        0 is visited but not the parent of 2 → Cycle detected!
        Cycle Found! The function returns true to 1, 0, and finally to detectCycle().

    detectCycle returns true, and "Graph contains cycle" is printed.
*/