import java.util.ArrayList;

public class BipartiteUndirected {
    public static class Edge{
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        /*
         *    1 ----> 0 -----> 2
         *            ↑       / 
         *            \      /
         *             \    / 
         *              \ ↙ 
         *               3
         */

        // Vertex - 0
        graph[0].add(new Edge(0, 2));

        // Vertex - 1
        graph[1].add(new Edge(1, 0));

        // Vertex - 2
        graph[2].add(new Edge(2, 3));

        // Vertex - 3
        graph[3].add(new Edge(3, 0));
    }
    public static boolean isCycle(ArrayList<Edge>[] graph){
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] stack = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]) {
                if(isCyclicUtil(i, graph, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
        // isCycle checks for cycles in the graph using DFS (Depth-First Search). It initializes arrays visited and stack to keep track of visited vertices and the current recursion stack for DFS. It iterates through each vertex, and if a vertex hasn't been visited, it calls isCyclicUtil to check for cycles starting from that vertex.
    }
    public static boolean isCyclicUtil(int current, ArrayList<Edge>[] graph, boolean[] visited, boolean[] stack) {
        visited[current] = true;
        stack[current] = true;
        for (Edge edge : graph[current]) {
            int neighbor = edge.destination;
            if (stack[neighbor]) {
                return true;
            }
            if(!visited[neighbor] && isCyclicUtil(neighbor, graph, visited, stack)){
                return true;
            }
        }
        stack[current] = false;
        return false;
        // isCyclicUtil is a recursive helper function used by isCycle. It marks the current vertex as visited and adds it to the recursion stack. It then iterates through all adjacent vertices (neighbor) of the current vertex (current), checking for cycles - If a neighboring vertex is in the current recursion stack (stack[neighbor]), a cycle is detected. If a neighboring vertex hasn't been visited, it recursively calls itself to check for cycles from that vertex. After exploring all neighbors, it removes the current vertex from the stack (stack[current] = false) to backtrack.
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        if (isCycle(graph)) {
            System.out.println("Graph contains cycle");
        }else{
            System.out.println("Graph doesn't contain cycle");
        }
    }
}

/*
    DFS Traversal from Vertex 0 -
        isCyclicUtil(0, graph, visited, stack) is called.
        Marks visited[0] = true, stack[0] = true.
        Iterates over neighbors of 0 → found neighbor 2.
        Since visited[2] = false, recursively calls isCyclicUtil(2, graph, visited, stack).

    DFS Traversal from Vertex 2 -
        isCyclicUtil(2, graph, visited, stack) is called.
        Marks visited[2] = true, stack[2] = true.
        Iterates over neighbors of 2 → found neighbor 3.
        Since visited[3] = false, recursively calls isCyclicUtil(3, graph, visited, stack).

    DFS Traversal from Vertex 3 -
        isCyclicUtil(3, graph, visited, stack) is called.
        Marks visited[3] = true, stack[3] = true.
        Iterates over neighbors of 3 → found neighbor 0.
        stack[0] == true → Back Edge Detected → Cycle Found!
        isCyclicUtil(3, graph, visited, stack) returns true to isCyclicUtil(2, graph, visited, stack).
        isCyclicUtil(2, graph, visited, stack) returns true to isCyclicUtil(0, graph, visited, stack).
        isCyclicUtil(0, graph, visited, stack) returns true to isCycle(graph).
        isCycle(graph) returns true to main().
*/