/*
    You are given two integer arrays persons and times. In an election, the ith vote was cast for persons[i] at time times[i].

    For each query at a time t, find the person that was leading the election at time t. Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.

    Implement the TopVotedCandidate class -
        TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
        int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
    
    Example 1 -
        Input - 
            ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
            [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]

        Outpu - [null, 0, 1, 1, 0, 0, 1]
        Explanation - 
            TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
            topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
            topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
            topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
            topVotedCandidate.q(15); // return 0
            topVotedCandidate.q(24); // return 0
            topVotedCandidate.q(8); // return 1
*/

import java.util.Arrays;
import java.util.Map;

public class OnlineElection {
    /**
     * Your TopVotedCandidate object will be instantiated and called as such:
     * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
     * int param_1 = obj.q(t);
     */
    private int[] times;
    private int[] leaderAt; // leaderAt[i] = who is leading right after the i-th vote

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length;
        leaderAt = new int[n];

        // Map to track each candidate's vote count
        Map<Integer, Integer> count = new HashMap<>();
        int currentLeader = -1;
        int currentMaxVotes = 0;

        for(int i = 0; i < n; i++){
            int p = persons[i];
            int c = count.getOrDefault(p, 0) + 1;
            count.put(p, c);

            // If this candidate now has >= votes to the current max, they become the new leader. This handles ties by favoring the most recent vote.
            if(c >= currentMaxVotes){
                currentLeader = p;
                currentMaxVotes = c;
            }
            leaderAt[i] = currentLeader;
        }
    }
    
    public int q(int t) {
        // Find rightmost index i such that times[i] <= t
        int index = Arrays.binarySearch(times, t);
        if (index < 0) {
            // binarySearch returns (-(insertion point) - 1) if not found
            index = -index - 2;
        }
        // If t is before the first vote, idx will be -1. Problem guarantees queries are within the vote times, but we can guard by returning -1 or throwing.
        if (index < 0) return -1;
        return leaderAt[index];
    }
}