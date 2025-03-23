/*
    Given a sorted integer array arr, two integers k and x, return the k 
    closest integers to x in the array. The result should also be sorted 
    in ascending order. An integer a is closer to x than an integer b if -
    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b

    Example 1 -
        Input - arr = [1,2,3,4,5], k = 4, x = 3
        Output - [1,2,3,4]

    Example 2 -
        Input - arr = [1,1,2,3,4,5], k = 4, x = -1
        Output - [1,1,2,3]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int integer : arr){
            if(k > 0){
                minHeap.offer(integer);
                k--;
            }else if(Math.abs(minHeap.peek()-x) > Math.abs(integer-x)){
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!minHeap.isEmpty()){
            list.add(minHeap.poll());
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }
}