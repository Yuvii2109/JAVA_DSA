// We are given an MxN binary matrix of 1's(soldier) and 0's(civilians).
// The soldiers are positioned in front of the civilians. That is, all the
// 1's will appear to the left of all the 0's in each row. A row i is 
// weaker than a row j if one of the following is true - 
// 1. The number of soldiers in i is less than the number of soldier in j.
// 2. Both rows have the same number of soldiers and i < j.
// Find the k weakest rows.

import java.util.*;

public class WeakestSoldier {
    public static class Row implements Comparable<Row>{
        int soldiers, index;
        public Row(int soldiers, int index){
            this.soldiers = soldiers;
            this.index = index;
        }
        @Override
        public int compareTo(Row other){
            if(this.soldiers == other.soldiers){
                return this.index - other.index;
                // Same number of soldiers hone par compare the index i, j
            }else{
                return this.soldiers - other.soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 0, 0}, 
            {1, 1, 1, 1}, 
            {1, 0, 0, 0}, 
            {1, 0, 0, 0}
        };
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            int soldiers = 0;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    soldiers++;
                }
            }
            pq.add(new Row(soldiers, i));
        }
        // Now we have a min heap of rows. We need to get the k weakest rows.
        // We can do this by popping the top k elements from the heap.
        int count = 0;
        while(count < k && !pq.isEmpty()){
            Row row = pq.poll();
            System.out.println("Row " + (row.index+1) + " is the weakest with " + row.soldiers + " soldier.");
            count++;
        }
    }
}