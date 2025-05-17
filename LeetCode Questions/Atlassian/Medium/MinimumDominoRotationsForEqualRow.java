/*
    In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

    We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

    Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

    If it cannot be done, return -1. 

    Example 1 -
        Input - tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
        Output - 2
        Explanation - The first figure represents the dominoes as given by tops and bottoms - before we do any rotations.
        If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

    Example 2 -
        Input - tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
        Output - -1
        Explanation - In this case, it is not possible to rotate the dominoes to make one row of values equal.
*/

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Try to make all values in the top (or bottom) row equal to tops[0]. If that fails, try bottoms[0]. If both fail, answer is -1.
        int ans = check(tops, bottoms, tops[0]);
        if(ans != -1 || tops[0] == bottoms[0]){
            // If we succeeded with tops[0], or tops[0] == bottoms[0] (both candidates same), we can return immediately.
            return ans;
        }
        // Otherwise, Let's consider bottom[0]
        return check(tops, bottoms, bottoms[0]);
    }
    /*
        Returns the minimum rotations needed to make every value in tops[] equal to x (by possibly rotating some dominoes), OR to make every value in bottoms[] equal to x, whichever is smaller. If it’s impossible, returns -1. 
        We count two things - 
        rotTop - number of rotations needed so that tops[i] == x for all i
        rotBot - number of rotations needed so that bottoms[i] == x for all i 
        
        For each i -
            1) If neither tops[i] nor bottoms[i] is x, we can’t use x at all → return -1.
            2) Else if tops[i] != x, we must rotate this domino to bring x into the top row → rotTop++.
            3) Else if bottoms[i] != x, we must rotate to bring x into the bottom row → rotBot++. 
        At the end, the answer is min(rotTop, rotBot).
    */
    private int check(int[] tops, int[] bottoms, int x){
        int rotTop = 0, rotBot = 0;
        for(int i = 0; i < tops.length; i++){
            // If x is neither in tops nor in bottoms, return -1
            if(bottoms[i] != x && tops[i] != x){
                return -1;
            }
            // If top is not x, rotate this one to move x to the top
            if(tops[i] != x){
                rotTop++;
            }
            // If bottom is not x, rotate this one to move x to the bottom
            if(bottoms[i] != x){
                rotBot++;
            }
        }
        // We can choose to make either the top row all x (rotTop rotations) or the bottom row all x (rotBot rotations), but we have to take the smaller one.
        return Math.min(rotTop, rotBot);
    }
}