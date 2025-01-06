// We are given a bar of chocolate composed of M x N square pieces. One 
// should break the chocolate into single squares. Each break of a part of
// chocolate is charged a cost expressed by a positive integer. This cost 
// does not depend on the size of the part that is being broken but only
// depends on the line the break goes along. Let us denote the costs of 
// breaking along consecutive vertical lines with x1, x2, ..., x(M-1) and
// along horizontal lines with y1, y2, ..., y(N-1). Compute the minimal cost
// of breaking the chocolate bar into single squares.

import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        int M = 6;
        int N = 4;
        Integer verticalCost[] = {2, 1, 3, 1, 4}; // M-1
        Integer horizontalCost[] = {4, 1, 2}; // N-1
        // M and N represent the dimensions of the chocolate bar.
        // verticalCost[] contains costs for breaking along the 
        // M−1 vertical lines (between columns).
        // horizontalCost[] contains costs for breaking along the 
        // N−1 horizontal lines (between rows).

        Arrays.sort(verticalCost, Collections.reverseOrder());
        Arrays.sort(horizontalCost, Collections.reverseOrder());
        int h = 0, v = 0;
        int horizontalPieces = 1, verticalPieces = 1;
        int minCost = 0;

        // Mantra - Mehnga wala pehle kaatna ka mittr
        while(h < horizontalCost.length && v < verticalCost.length){
            if(horizontalCost[h] >= verticalCost[v]){
                minCost += horizontalCost[h] * verticalPieces;
                h++;
                horizontalPieces++;
            }else{
                minCost += verticalCost[v] * horizontalPieces;
                v++;
                verticalPieces++;
            }
        }
        // The loop runs as long as there are unprocessed elements in 
        // both horizontalCost and verticalCost.
        // Comparison:
        // If the current horizontal cost (horizontalCost[h]) is greater 
        // than or equal to the current vertical cost (verticalCost[v]):
        // Perform a horizontal break.
        // Add the cost of the break, multiplied by the number of vertical 
        // pieces (verticalPieces), to minCost.
        // Increment h (move to the next horizontal cost).
        // Increment horizontalPieces (increase the count of horizontal pieces).
        // Otherwise:
        // Perform a vertical break.
        // Add the cost of the break, multiplied by the number of horizontal 
        // pieces (horizontalPieces), to minCost.
        // Increment v (move to the next vertical cost).
        // Increment verticalPieces (increase the count of vertical pieces).

        // Handling the remaining costs if any - 
        while(h < horizontalCost.length){
            minCost += horizontalCost[h] * verticalPieces;
            h++;
            horizontalPieces++;
        }
        while(v < verticalCost.length){
            minCost += verticalCost[v] * horizontalPieces;
            v++;
            verticalPieces++;
        }
        
        System.out.println("Minimum cost to cut the entire chocolate - " + minCost);
    }
}