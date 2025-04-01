/*
    You and a gang of thieves are planning on robbing a bank. You are 
    given a 0-indexed integer array security, where security[i] is the 
    number of guards on duty on the ith day. The days are numbered 
    starting from 0. You are also given an integer time. The ith day is a 
    good day to rob the bank if -

    There are at least time days before and after the ith day,
    The number of guards at the bank for the time days before i are 
    non-increasing, and The number of guards at the bank for the time days 
    after i are non-decreasing. More formally, this means day i is a good 
    day to rob the bank if and only if security[i - time] >= security[i - 
    time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= 
    security[i + time]. Return a list of all days (0-indexed) that are 
    good days to rob the bank. The order that the days are returned in 
    does not matter.

    Example 1 -
        Input - security = [5,3,3,3,5,6,2], time = 2
        Output - [2,3]
        Explanation - On day 2, we have security[0] >= security[1] >= security [2] <= security[3] <= security[4]. On day 3, we have 
        security[1] >= security[2] >= security[3] <= security[4] <= 
        security[5]. No other days satisfy this condition, so days 2 and 3 
        are the only good days to rob the bank.

    Example 2 -
        Input - security = [1,1,1,1,1], time = 0
        Output - [0,1,2,3,4]
        Explanation - Since time equals 0, every day is a good day to rob 
        the bank, so return every day.

    Example 3 -
        Input - security = [1,2,3,4,5,6], time = 2
        Output - []
        Explanation - No day has 2 days before it that have a 
        non-increasing number of guards. Thus, no day is a good day to rob 
        the bank, so return an empty list.
*/

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        /*
            List<Integer> goodDays = new ArrayList<>();
            int n = security.length;
            for(int i = time; i <= (n-time-1); i++){
                boolean isGoodDay = true;
                // Checking non-increasing condition for days before i
                for(int j = 1; j <= time; j++){
                    if(security[i-j] < security[i-j+1]){
                        isGoodDay = false;
                        break;
                    }
                }
                // Checking non-decreasing condition for days after i
                for(int j = 1; j <= time; j++){
                    if(security[i+j] < security[i+j-1]){
                        isGoodDay = false;
                        break;
                    }
                }
                if(isGoodDay){
                    goodDays.add(i);
                }
            }
            return goodDays;
        */
        // TLE aagya so trying to do better
        List<Integer> goodDays = new ArrayList<>();
        int n = security.length;
        if(time == 0){
            for(int i = 0; i < n; i++){
                goodDays.add(i);
            }
            return goodDays;
        }
        int[] nonDecreasing = new int[n]; // Count of consecutive non-decreasing days
        int[] nonIncreasing = new int[n]; // Count of consecutive non-increasing days
        // Computing nonIncreasing[] (left to right)
        for(int i = 1; i < n; i++){
            if(security[i] <= security[i-1]){
                nonIncreasing[i] = nonIncreasing[i-1] + 1;
            }
        }
        // Computing nonDecreasing[] (right to left)
        for(int i = n-2; i >= 0; i--){
            if(security[i] <= security[i+1]){
                nonDecreasing[i] = nonDecreasing[i+1] + 1;
            }
        }
        // Finding ideal days to steal XD
        for(int i = time; i < n-time; i++){
            if(nonIncreasing[i] >= time && nonDecreasing[i] >= time){
                goodDays.add(i);
            }
        }
        return goodDays;
    }
}