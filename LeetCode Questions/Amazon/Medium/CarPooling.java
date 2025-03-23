/*
    There is a car with capacity empty seats. The vehicle only drives east 
    (i.e., it cannot turn around and drive west). You are given the 
    integer capacity and an array trips where trips[i] = [numPassengersi, 
    fromi, toi] indicates that the ith trip has numPassengersi passengers 
    and the locations to pick them up and drop them off are fromi and toi 
    respectively. The locations are given as the number of kilometers due 
    east from the car's initial location. Return true if it is possible to 
    pick up and drop off all passengers for all the given trips, or false 
    otherwise. 

    Example 1 -
        Input - trips = [[2,1,5],[3,3,7]], capacity = 4
        Output - false

    Example 2 -
        Input - trips = [[2,1,5],[3,3,7]], capacity = 5
        Output - true
*/

public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int maxDrops = 0;
        // To find maximum drop-off locations
        for(int[] trip : trips){
            maxDrops = Math.max(maxDrops, trip[2]);
        }
        // Creates and array to track passenger changesat each location
        int stops[] = new int[maxDrops+1];
        // Processing each trip 
        for(int trip[] : trips){
            int numberOfPassengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            stops[start] += numberOfPassengers;
            stops[end] -= numberOfPassengers;
        }
        // Traversing the stops array to check the capacity
        int currentCapacity = 0;
        for(int passengers : stops){
            currentCapacity += passengers;
            if(currentCapacity > capacity){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        int capacity2 = 5;
        System.out.println(carPooling(trips, capacity1));
        System.out.println(carPooling(trips, capacity2));
    }
}