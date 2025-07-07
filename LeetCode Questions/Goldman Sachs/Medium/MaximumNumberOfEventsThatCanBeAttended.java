/*
    You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

    You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

    Return the maximum number of events you can attend.

    Example 1 -
        Input - events = [[1,2],[2,3],[3,4]]
        Output - 3
        Explanation - You can attend all the three events.
            One way to attend them all is as shown.
            Attend the first event on day 1.
            Attend the second event on day 2.
            Attend the third event on day 3.

    Example 2 -
        Input - events= [[1,2],[2,3],[3,4],[1,2]]
        Output - 4
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0; 
        int day = 0;
        int i = 0;
        int n = events.length;

        while(i < n || !minHeap.isEmpty()){
            // If no pending events, jump day to next event's start
            if(minHeap.isEmpty()){
                day = events[i][0];
            }
            // Add all events that start on or before 'day'
            while(i < n && events[i][0] <= day){
                minHeap.offer(events[i][1]);
                i++;
            }
            // Remove expired events (end < current day)
            while(!minHeap.isEmpty() && minHeap.peek() < day){
                minHeap.poll();
            }
            // Attend the event that ends the soonest
            if(!minHeap.isEmpty()){
                minHeap.poll();
                count++;
                day++; // Move to next day after attending
            }
        }
        return count;
    }
}