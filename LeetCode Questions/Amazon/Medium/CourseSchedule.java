/*
    There are a total of numCourses courses you have to take, labeled from 
    0 to numCourses - 1. You are given an array prerequisites where 
    prerequisites[i] = [ai, bi] indicates that you must take course bi 
    first if you want to take course ai. For example, the pair [0, 1], 
    indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false. 

    Example 1 -
        Input - numCourses = 2, prerequisites = [[1,0]]
        Output - true
        Explanation - There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0. So it is possible.

    Example 2 -
        Input - numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output - false
        Explanation - There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency List to represent the course dependency graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        // Creating an array to store the in-degree (number of pre-requisites)
        int inDegree[] = new int[numCourses];
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            // Adding an edge from "prerequisite" to "course"
            adj.get(prerequisite).add(course);
            // Incrementing indegree for the course;
            inDegree[course]++;
        }

        // Using a queue to process courses that have no prerequisites
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        // Processing courses in the queue
        while(!q.isEmpty()){
            int current = q.poll();
            count++; // One more course can be finished
            // For each course that depends on the current course
            for(int neighbor : adj.get(current)){
                inDegree[neighbor]--; // Remove the dependency
                // If the neighbor has no more prerequisites, add it to the q
                if(inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        // If we processed all courses, it means it's possible to finish them
        return count == numCourses;
    }
}