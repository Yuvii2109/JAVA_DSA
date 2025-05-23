/*
    In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.

    The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

    You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

    Return a string of all teams sorted by the ranking system. 

    Example 1 -
        Input - votes = ["ABC","ACB","ABC","ACB","ACB"]
        Output - "ACB"
        Explanation - Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
        Team B was ranked second by 2 voters and ranked third by 3 voters.
        Team C was ranked second by 3 voters and ranked third by 2 voters.
        As most of the voters ranked C second, team C is the second team, and team B is the third.

    Example 2 -
        Input - votes = ["WXYZ","XYZW"]
        Output - "XWYZ"
        Explanation - X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position. 

    Example 3 -
        Input - votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
        Output - "ZMNAGUEDSJYLBOPHRQICWFXTVK"
        Explanation - Only one voter, so their votes are used for the ranking.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RankTeamByVotes {
    public String rankTeams(String[] votes) {
        if(votes == null || votes.length == 0) return "";
        int n = votes[0].length(); // Number of teams
        int m = votes.length; // Number of voters

        // Map each team to an array of counts - counts[pos] = number of votes at (0-based) position pos
        Map<Character, int[]> freq = new HashMap<>();
        for(char c : votes[0].toCharArray()){
            freq.put(c, new int[n]);
        }

        // Tally all votes
        for (String vote : votes) {
            for (int pos = 0; pos < vote.length(); pos++) {
                char team = vote.charAt(pos);
                freq.get(team)[pos]++;
            }
        }

        // Extract the list of teams
        List<Character> teams = new ArrayList<>(freq.keySet());
        // Sort according to the rules -
        // 1) Higher count of position-0 votes wins
        // 2) If tie, compare position-1 counts, etc.
        // 3) If still tie after all positions, smaller letter (alphabetical) wins.
        teams.sort((a, b) -> {
            int[] countA = freq.get(a);
            int[] countB = freq.get(b);
            for(int i = 0; i < n; i++){
                if(countA[i] != countB[i]){
                    // descending order of votes
                    return countB[i] - countA[i];
                }
            }
            // fully tied - alphabetical
            return a - b;
        });

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (char c : teams) {
            sb.append(c);
        }
        return sb.toString();
    }
}