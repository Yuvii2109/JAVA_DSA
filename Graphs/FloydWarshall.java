import java.util.Arrays;

class FloydWarshall {
    final static int INF = Integer.MAX_VALUE; // A large value representing infinity

    // Function to implement Floyd-Warshall Algorithm
    static void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        // Copy input graph to distance matrix
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) { // Picking every node as an intermediate
            for (int i = 0; i < V; i++) { // Iterating over all pairs
                for (int j = 0; j < V; j++) {
                    // Update dist[i][j] only if k is a better intermediate and no overflow risk
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Print final shortest distance matrix
        printSolution(dist, V);
    }

    // Function to print distance matrix
    static void printSolution(int dist[][], int V) {
        System.out.println("Shortest distance matrix - ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF){
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int graph[][] = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };
        /*
                _______
              ↙    2   \
            (0)---3--->(1)
             |      ___/↑ 
             5  __4/    1  
             ↓↙         | 
            (3)--2---->(2)
        */
        floydWarshall(graph, V);
    }
}