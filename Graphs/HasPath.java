import java.util.ArrayList;

public class HasPath {
    public static class Edge{
        int source, destination, weight;
        public Edge(int source, int destination, int weight){
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

    public static boolean hasPath(ArrayList<Edge> graph[], int source, int destination, boolean visited[]){
        // Tells if ek vertex se doosre vertex tak path exist krta hai ya nahi... basically - 0th vertex se 6th vertex tak path exist krta hai but 9th vertex se 7th vertex tak path exist nahi karta

        // Parameters -
        // graph[] - The graph represented as an adjacency list.
        // source - Starting vertex for path search.
        // destination - Target vertex for path search.
        // visited[] - Array to keep track of visited vertices to avoid cycles.

        if(source == destination){
            return true;
        }
        visited[source] = true;
        for(int i = 0; i < graph[source].size(); i++){
            Edge edge = graph[source].get(i);
            if(!visited[edge.destination] && hasPath(graph, edge.destination, destination, visited)){
                return true;
            }
        }
        return false;

        // Base Case - If source equals destination, it means we have found a path, so return true. Mark the current source vertex as visited (visited[source] = true). Iterates through all edges (graph[source]) connected to the current source vertex. Recursively checks if there is a path from the current edge's destination (edge.destination) to the destination vertex. If such a path is found, it returns true; otherwise, it continues to check other edges. If no path is found from source, it returns false.
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited[] = new boolean[vertices];
        if(hasPath(graph, 0, 6, visited)){
            System.out.println("Path exists");
        }else{
            System.out.println("Path does not exist");
        }
    }
}

// Time complexity - O(V+E)

/*
    Function Call - hasPath(graph, 0, 6, visited)
        Source - 0, Destination - 6
        visited[0] = true
        Check edges of 0 - (0 → 1) and (0 → 2)

    Function Call - hasPath(graph, 1, 6, visited)
        Source - 1, Destination - 6
        visited[1] = true
        Check edges of 1 - (1 → 0), (1 → 3)
        (1 → 0) is ignored (already visited).

    Call hasPath(graph, 3, 6, visited)
        Function Call - hasPath(graph, 3, 6, visited)
        Source - 3, Destination - 6
        visited[3] = true
        Check edges of 3 - (3 → 1), (3 → 4), (3 → 5)
        (3 → 1) is ignored (already visited).

    Call hasPath(graph, 4, 6, visited)
        Function Call - hasPath(graph, 4, 6, visited)
        Source - 4, Destination - 6
        visited[4] = true
        Check edges of 4 - (4 → 2), (4 → 3), (4 → 5)
        (4 → 2), (4 → 3) are ignored (already visited).
        When hasPath(graph, 4, 6, visited) was executing, it had three neighbors - {2, 3, 5}. It first checked (4 → 3), but 3 was already visited. It then checked (4 → 5), which led to the correct path to 6. Since hasPath(graph, 5, 6, visited) found the path to 6, it immediately returned true, without needing to check (4 → 2). 
        The adjacency list order ({2, 3, 5}) does suggest 2 should be checked before 5. However, recursion can reorder the execution:
        The function call hasPath(graph, 4, 6, visited) was initiated from 3, not 2. Since 3 was processed before 2, it led to 4 first. Then 4 checked 5 before returning to check 2. But because 5 → 6 immediately returned true, 2 was never explored.

    Call hasPath(graph, 5, 6, visited)
        Function Call - hasPath(graph, 5, 6, visited)
        Source - 5, Destination - 6
        visited[5] = true
        Check edges of 5 - (5 → 3), (5 → 4), (5 → 6)
        (5 → 3), (5 → 4) are ignored (already visited).

    Call hasPath(graph, 6, 6, visited)
        Base Case Reached - hasPath(graph, 6, 6, visited)
        Source = Destination → Return true
        This true propagates back through all previous recursive calls.
*/