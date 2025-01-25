/*
    "Paris" -> "Italy"
    "London" -> "Dubai"
    "France" -> "Paris"
    "Dubai" -> "France"
*/

import java.util.HashMap;

public class FindIteneraryFromTickets {
    public static String getStart(HashMap<String, String> tickets){
        // Step 1 - Create a reverse map to find the starting point
        HashMap<String, String> reverseMap = new HashMap<>();
        for(String key : tickets.keySet()){
            reverseMap.put(tickets.get(key), key); 
            // This maps destination to source - destination -> source
        }
        
        // Step 2 - Find the starting point which does not have a previous destination
        for(String key : tickets.keySet()){
            if(!reverseMap.containsKey(key)){
                return key; // This is our starting point
            }
        }
        return null; // Return null if no starting point is found (though logically it shouldn't happen with valid data)
    }
    
    public static void main(String[] args) {
        // Step 3 - Define and populate the tickets HashMap
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Paris", "Italy");
        tickets.put("London", "Dubai");
        tickets.put("France", "Paris");
        tickets.put("Dubai", "France");
        
        // Step 4 - Get the starting point
        String start = getStart(tickets);
        System.out.print(start); // Print the starting point
        
        // Step 5 - Print the itinerary
        for(String key : tickets.keySet()){
            System.out.print(" -> " + tickets.get(start)); // retrieves destination
            start = tickets.get(start); // Update start to the next destination
        }
    }
}