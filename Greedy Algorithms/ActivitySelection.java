// You are given n activities with their start and end times. Select the
// maximum number of activities that can be performed by a single person, 
// assuming that a person can only work on a single activity at a time.
// Activities are sorted according to end time.
// start = [10, 12, 20]
// end = [20, 25, 30]
// Output - 2 (Activity_1 and Activity_3)

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {0, 1, 3, 5, 5, 8};
        int end[] = {6, 2, 4, 7, 9, 9};

        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};
        // This array is already sorted on the basis of end time...
        // Toh abhi toh hume sort krne ki zaroort nahi hai but agar sorted
        // nahi hai toh hume sort krna hoga or ab vo kaise karenge ? 
        // Tumhara bhai krke btayega rey baba -

        // Sorting -
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; // Column 1 - indexes
            activities[i][1] = start[i]; // Column 2 - start time
            activities[i][2] = end[i]; // Column 3 - end time
        }
        // Lambda Function hai to sort a 2D Array
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        // Ab hume sort krna tha end time ke liye isliye o -> o[2] likha hai

        // Sorted 2D array - 
        for(int i = 0; i < start.length; i++){
            System.out.println(Arrays.toString(activities[i]));
        }

        int maxActivity = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int n = end.length;

        // Ab humne first activity include isliye kr li hai kyuki agar
        // humne end time ke according sort kr krdia hai ascending order main 
        // toh first activity hi sabse pehle end hogi or agar hume sorted array
        // end time ke basis pr hi milna chahiye agar start time ke according sorted
        // hai toh we might not get the right answer 
        maxActivity = 1;
        result.add(activities[0][0]); // result.add(q);
        int lastEnd = activities[0][2]; // int lastEnd = end[0];
        for (int i = 1; i < n; i++) {
            if(activities[i][1] >= lastEnd){ // if (start[i] >= lastEnd) {
                maxActivity++;
                result.add(activities[i][0]); // result.add(i);
                lastEnd = activities[i][2]; // lastEnd = end[i];
            }
        }
        System.out.println("Maximum Activities - " + maxActivity);
        for(int i = 0; i < result.size(); i++){
            System.out.println("Activity " + (result.get(i)) + " - Start: " + start
            [result.get(i)] + ", End: " + end[result.get(i)]);
        }
    }
}

// Time Complexity - O(nlogn)