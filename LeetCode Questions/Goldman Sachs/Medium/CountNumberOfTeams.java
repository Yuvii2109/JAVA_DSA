/*
    There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

    You have to form a team of 3 soldiers amongst them under the following rules -
        Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
        A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
        Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

    Example 1 -
        Input - rating = [2,5,3,4,1]
        Output - 3
        Explanation - We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 

    Example 2 -
        Input - rating = [2,1,3]
        Output - 0
        Explanation - We can't form any team given the conditions.

    Example 3 -
        Input - rating = [1,2,3,4]
        Output - 4
*/

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for(int j = 0; j < n; j++){
            // We treat each position j as the “middle” soldier of a team (i < j < k).
            int leftSmaller = 0, leftGreater = 0;
            int rightSmaller = 0, rightGreater = 0;

            // Count how many soldiers to the left of j have a rating smaller than rating[j], and how many have a rating greater.
            for(int i = 0; i < j; i++){
                if(rating[i] < rating[j]){
                    leftSmaller++;
                }else if(rating[i] > rating[j]){
                    leftGreater++;
                }
            }
            // Count how many soldiers to the right of j have a rating greater than rating[j], and how many have a rating smaller.
            for(int k = j + 1; k < n; k++){
                if(rating[k] > rating[j]){
                    rightGreater++;
                }else if(rating[k] < rating[j]){
                    rightSmaller++;
                }
            }
            // Any valid increasing team with j in the middle must pick one smaller on the left and one greater on the right - teams_increasing = leftSmaller * rightGreater

            // Any valid decreasing team with j in the middle must pick one greater on the left and one smaller on the right - teams_decreasing = leftGreater * rightSmaller

            // Add both to our total count.
            count += leftSmaller * rightGreater + rightSmaller * leftGreater;
        }
        return count;
    }
}