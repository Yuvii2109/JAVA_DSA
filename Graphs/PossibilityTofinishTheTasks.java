// Find whether it is possible to nish all tasks or not -
// There are a total of n tasks you have to pick, labelled from 0 to n-1. Some tasks may have prerequisites, for example to pick task 0 you have to first pick task 1, which is expressed as a pair - [0, 1]. Given the total number of tasks and a list of prerequisite pairs, is it possible for you to finish all tasks?
// Sample Input 1 - [[1, 0], [0, 1]]
// Sample Output 1 - false
// Sample Input 2 - [[1, 0]]
// Sample Output 2 - true

import java.util.*;

public class PossibilityTofinishTheTasks {
    
    // Function to determine if all tasks can be finished.
    // numTasks - total number of tasks (labeled from 0 to numTasks-1)
    // prerequisites - 2D array where each pair [x, y] means you must finish task y before task x.
    public boolean canFinish(int numTasks, int[][] prerequisites) {
        // Step 1 - Build the graph and initialize in-degrees.
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numTasks]; // inDegree[i] is the number of prerequisites for task i.
        
        // Initialize the graph for each task.
        for (int i = 0; i < numTasks; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the graph with edges and update in-degrees.
        for (int[] pre : prerequisites) {
            int task = pre[0];      // Task to be done.
            int prereq = pre[1];    // Its prerequisite.
            
            // Add an edge from prereq to task.
            graph.get(prereq).add(task);
            
            // Increase the in-degree of task.
            inDegree[task]++;
        }
        
        // Step 2 - Use Kahn's algorithm for topological sort.
        // Start with all tasks that have no prerequisites.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numTasks; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0; // Count how many tasks can be processed.
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;  // We are able to "finish" this task.
            
            // For each task that depends on the current task,
            // reduce its in-degree since one prerequisite has been completed.
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                
                // If a neighbor now has no prerequisites, add it to the queue.
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 3 - Check if all tasks were processed.
        // If count == numTasks, we managed to finish all tasks.
        return count == numTasks;
    }
    
    public static void main(String[] args) {
        PossibilityTofinishTheTasks solver = new PossibilityTofinishTheTasks();
        
        // Sample Input 1 - [[1, 0], [0, 1]] should return false.
        int[][] prerequisites1 = { {1, 0}, {0, 1} };
        System.out.println(solver.canFinish(2, prerequisites1));
        
        // Sample Input 2 - [[1, 0]] should return true.
        int[][] prerequisites2 = { {1, 0} };
        System.out.println(solver.canFinish(2, prerequisites2)); 
    }
}

/*
    Example 1 -
        Input - [[1, 0], [0, 1]] with numTasks = 2
        Graph Construction -
        Edge from 0 to 1 → inDegree[1] becomes 1.
        Edge from 1 to 0 → inDegree[0] becomes 1.
        Queue Initialization -
        No task has inDegree == 0 (both tasks have in-degree 1), so the queue is empty.
        Result -
        count remains 0, which is less than 2 → returns false.

    Example 2 -
        Input - [[1, 0]] with numTasks = 2
        Graph Construction -
        Edge from 0 to 1 → inDegree[1] becomes 1.
        Queue Initialization -
        Task 0 has no prerequisites (inDegree[0] == 0), so it is added to the queue.
        Processing -
        Remove task 0 from the queue (count becomes 1).
        For task 0’s neighbor (task 1), decrement inDegree[1] to 0 and add task 1 to the queue.
        Remove task 1 from the queue (count becomes 2).
        Result -
        count equals numTasks (2) → returns true.
*/