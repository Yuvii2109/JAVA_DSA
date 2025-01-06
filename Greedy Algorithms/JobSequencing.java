// Given an array of jobs where every job has a deadline and profit if 
// the job is finished before the deadline, it is also given that every
// job takes a single unit of time, so the minimum possible deadline of
// any job is 1. Maximise the total profit if only one job can be scheduled
// at a time. "Job - deadline, profit"
// Job A - 4, 20
// Job B - 1, 10
// Job C - 1, 40
// Job D - 1, 30
// Output - C, A

import java.util.*;

public class JobSequencing {
    public static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int deadline, int profit, int id) {
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }
    // Purpose: Represents a job with three properties:
    // deadline: The latest time by which the job must be completed.
    // profit: The profit earned if the job is completed within the deadline.
    // id: A unique identifier for each job, corresponding to its index in the input.
    // Constructor: Initializes the job attributes when a Job object is created.

    public static void main(String args[]){
        int[][] jobInfo = {{4, 20},{1, 10},{1, 40},{1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i = 0; i < jobInfo.length; i++){
            jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i));
        }
        
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        // Sorts the jobs list in descending order of profit using a comparator.
        // b.profit - a.profit ensures that jobs with higher profits come first.
        // Why Sort by Profit:
        // Maximizing profit involves considering the most profitable jobs
        // first while scheduling.

        ArrayList<Integer> order = new ArrayList<>();
        int time = 0;
        for(Job job : jobs){
            if(time + 1 <= job.deadline){
                order.add(job.id);
                time++;
            }
        }
        // order - A list to store the IDs of selected jobs.
        // time - Tracks the number of jobs scheduled so far.
        // For Loop -
        // Iterates through the sorted jobs list (starting with the 
        // highest profit job).
        // Condition - if (time + 1 <= job.deadline):
        // Ensures that scheduling this job does not exceed its deadline.
        // If the job fits, add its id to order and increment time.
        // Why Check the Deadline:
        // Each job takes 1 unit of time, so a job can only be scheduled if 
        // time + 1 is less than or equal to its deadline.

        int p = 0;
        for(int id : order){
            System.out.println("Job " + (id+1) + " with deadline " + jobs.get(id).deadline + " and profit " + jobs.get(id).profit);
            p += jobs.get(id).profit;
        }
        // p: Tracks the total profit of the selected jobs.
        // For Loop:
        // Iterates through the order list (which contains the IDs of selected jobs).
        // Prints details of each selected job:
        // id + 1: Outputs the job index (1-based for user readability).
        // jobs.get(id).deadline: Prints the job's deadline.
        // jobs.get(id).profit: Prints the job's profit.
        // Adds the job’s profit to the total p.

        System.out.println("Maximum profit - " + p);
        System.out.println("Jobs selected - " + order.size());
    }
}