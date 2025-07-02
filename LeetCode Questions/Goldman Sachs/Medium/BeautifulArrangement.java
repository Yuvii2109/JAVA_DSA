/*
    Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true -
        perm[i] is divisible by i.
        i is divisible by perm[i].
    
    Given an integer n, return the number of the beautiful arrangements that you can construct. 

    Example 1 -
    Input - n = 2
    Output - 2
    Explanation -
        The first beautiful arrangement is [1,2]:
            - perm[1] = 1 is divisible by i = 1
            - perm[2] = 2 is divisible by i = 2
        The second beautiful arrangement is [2,1]:
            - perm[1] = 2 is divisible by i = 1
            - i = 2 is divisible by perm[2] = 1
            
    Example 2 -
        Input - n = 1
        Output - 1
*/

public class BeautifulArrangement {
    private int count = 0;
    private boolean[] used;
    public int countArrangement(int n) {
        used = new boolean[n + 1];
        backtrack(n, 1);
        return count;
    }
    private void backtrack(int n, int index){
        if(index > n){
            count++;
            return;
        }
        for(int k = 1; k <= n; k++){
            if(!used[k] && ((k % index == 0) || (index % k == 0))){
                used[k] = true;
                backtrack(n, index + 1);
                used[k] = false; // Un‑choose (backtrack) so we can try another number here
            }
        }
    }
}