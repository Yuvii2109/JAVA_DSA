/*
    Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets. A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true - 
        0 <= i < j < k < arr.length
        |arr[i] - arr[j]| <= a
        |arr[j] - arr[k]| <= b
        |arr[i] - arr[k]| <= c
        Where |x| denotes the absolute value of x.
    Return the number of good triplets. 

    Example 1 -
        Input - arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
        Output - 4
        Explanation - There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].

    Example 2 -
        Input - arr = [1,1,2,2,3], a = 0, b = 0, c = 1
        Output - 0
        Explanation - No triplet satisfies all conditions.
*/

public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        /*
            Brute Force Approach - 

            for(int i = 0; i < n-2; i++){
                for(int j = i+1; j < n-1; j++){
                    for(int k = j+1; k < n; k++){
                        if(Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c){
                            count++;
                        }
                    }
                }
            }
        */
        // Let's fix a j - 
        for(int j = 1; j < n-1; j++){
            // Let's store an i for the fixed j
            for(int i = 0; i < j; i++){
                if(Math.abs(arr[i] - arr[j]) > a){
                    continue;
                }
                // Let's store k for j 
                for(int k = j+1; k < n; k++){
                    if(Math.abs(arr[j] - arr[k]) > b){
                        continue;
                    }
                    if(Math.abs(arr[i] - arr[k]) <= c){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

/*
    j = 1 (arr[j] = 0) - 
        i = 0 → |3 - 0| = 3 ≤ 7 ✅
        k = 2 → |0 - 1| = 1 ≤ 2 ✅, |3 - 1| = 2 ≤ 3 ✅ → ✅ Count = 1
        k = 3 → same as above → ✅ Count = 2
        k = 4 → |0 - 9| = 9 ❌ → skip
        k = 5 → |0 - 7| = 7 ❌ → skip

    ✅ j = 2 (arr[j] = 1) -
        i = 0 → |3 - 1| = 2 ≤ 7 ✅
        k = 3 → |1 - 1| = 0 ✅, |3 - 1| = 2 ✅ → ✅ Count = 3
        k = 4 → |1 - 9| = 8 ❌
        k = 5 → |1 - 7| = 6 ❌
        i = 1 → |0 - 1| = 1 ≤ 7 ✅
        k = 3 → |1 - 1| = 0 ✅, |0 - 1| = 1 ✅ → ✅ Count = 4
        k = 4 → |1 - 9| = 8 ❌
        k = 5 → |1 - 7| = 6 ❌

    ✅ j = 3 (arr[j] = 1) - 
        i = 0 → |3 - 1| = 2 ✅
        k = 4 → |1 - 9| = 8 ❌
        k = 5 → |1 - 7| = 6 ❌
        i = 1 → |0 - 1| = 1 ✅
        k = 4 → ❌
        k = 5 → ❌
        i = 2 → |1 - 1| = 0 ✅
        k = 4 → ❌
        k = 5 → ❌

    ✅ j = 4 (arr[j] = 9) - 
        i = 0 → |3 - 9| = 6 ✅
        k = 5 → |9 - 7| = 2 ✅, |3 - 7| = 4 ❌
        i = 1 → |0 - 9| = 9 ❌
        i = 2 → |1 - 9| = 8 ❌
        i = 3 → |1 - 9| = 8 ❌

    ✅ j = 5 (arr[j] = 7) - 
        i = 0 → |3 - 7| = 4 ✅ → no k after j
        i = 1, 2, 3, 4 → same case → no k after j

    Final Count - 4 Good Triplets
        These are - 
            (3, 0, 1)
            (3, 0, 1) [i=0, j=1, k=3]
            (3, 1, 1) [i=0, j=2, k=3]
            (0, 1, 1) [i=1, j=2, k=3]
*/