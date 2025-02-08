import java.util.PriorityQueue;

public class ConnectingCities {
    public static class Edge implements Comparable<Edge>{
        int destination, cost;
        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost; // Ascending order
        }
    }
    public static int connectingCities(int cities[][]){
        int n = cities.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[n];
        pq.add(new Edge(0, 0));
        int finalCost = 0;
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int destination = current.destination;
            int cost = current.cost;
            if(!visited[destination]){
                visited[destination] = true;
                finalCost += cost;
                for(int i = 0; i < n; i++){
                    if(cities[destination][i] != 0 && !visited[i]){
                        pq.add(new Edge(i, cities[destination][i]));
                    }
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][] = {
            {0, 1, 2, 3, 4}, 
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };
        System.out.println("Minimum Cost of Connecting the cities - " + connectingCities(cities));
    }
}