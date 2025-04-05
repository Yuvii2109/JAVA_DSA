/*
    The median is the middle value in an ordered integer list. If the size 
    of the list is even, there is no middle value, and the median is the 
    mean of the two middle values. For example, for arr = [2,3,4], the 
    median is 3. For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5. Implement the MedianFinder class -

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 
    Example 1 -
        Input - 
            ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
            [[], [1], [2], [], [3], []]
        Output - 
            [null, null, null, 1.5, null, 2.0]

        Explanation - 
            MedianFinder medianFinder = new MedianFinder();
            medianFinder.addNum(1);    // arr = [1]
            medianFinder.addNum(2);    // arr = [1, 2]
            medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
            medianFinder.addNum(3);    // arr[1, 2, 3]
            medianFinder.findMedian(); // return 2.0
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap; // To store the lower-half of the numbers
    private PriorityQueue<Integer> minHeap; // To store the upper-half of the numbers

    // Initializing the data structure
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num); // Adding to maxHeap first
        minHeap.offer(maxHeap.poll()); // Ensure that every element in maxHeap is less than or equal to that in minHeap

        // Balance the heaps so that maxHeap can have one extra element
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // If there are odd number of elements, maxHeap will have one element extra
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        // If even, median is the average of the two middle values
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */