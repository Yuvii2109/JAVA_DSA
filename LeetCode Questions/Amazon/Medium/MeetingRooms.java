/*
    Given an array arr of meeting time intervals consisting of start and 
    end times [[s1, e1], [s2, e2],...](si < ei), find the minimum number 
    of conference rooms required.

    Input - arr = [[0, 30], [5, 10], [15, 20]]
    Output - 2
*/

import java.util.TreeMap;

public class MeetingRooms {
    public static int minMeetingRooms(int arr[][]){
        if(arr.length == 0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i][0], map.getOrDefault(arr[i][0], 0) + 1);
            map.put(arr[i][1], map.getOrDefault(arr[i][1], 0) - 1);
        }
        int count = 0, max = 0;
        for(int value : map.values()){
            count += value;
            max = Math.max(max, count);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[][] = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(arr));
    }
}

/*
    For interval [0, 30] -
        map.put(0, map.getOrDefault(0, 0) + 1); → map.put(0, 1);
        map.put(30, map.getOrDefault(30, 0) - 1); → map.put(30, -1);
        map = { 0 → 1, 30 → -1 }

    For interval [5, 10] -
        map.put(5, map.getOrDefault(5, 0) + 1); → map.put(5, 1);
        map.put(10, map.getOrDefault(10, 0) - 1); → map.put(10, -1);
        map = { 0 → 1, 5 → 1, 10 → -1, 30 → -1 }

    For interval [15, 20] -
        map.put(15, map.getOrDefault(15, 0) + 1); → map.put(15, 1);
        map.put(20, map.getOrDefault(20, 0) - 1); → map.put(20, -1);
        map = { 0 → 1, 5 → 1, 10 → -1, 15 → 1, 20 → -1, 30 → -1 }
*/