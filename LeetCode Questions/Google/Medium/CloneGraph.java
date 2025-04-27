/*
    Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph. Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
        class Node {
            public int val;
            public List<Node> neighbors;
        }
    Test case format -    
        For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list. An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph. The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
    
    Example 1 -
        Input - adjList = [[2,4],[1,3],[2,4],[1,3]]
        Output - [[2,4],[1,3],[2,4],[1,3]]
        Explanation - There are 4 nodes in the graph.
        1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
        3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

    Example 2 -   
        Input - adjList = [[]]
        Output - [[]]
        Explanation - Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

    Example 3 -    
        Input - adjList = []
        Output - []
        Explanation - This an empty graph, it does not have any nodes.
*/

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    /*
        Definition for a Node -
            class Node {
                public int val;
                public List<Node> neighbors;
                public Node() {
                    val = 0;
                    neighbors = new ArrayList<Node>();
                }
                public Node(int _val) {
                    val = _val;
                    neighbors = new ArrayList<Node>();
                }
                public Node(int _val, ArrayList<Node> _neighbors) {
                    val = _val;
                    neighbors = _neighbors;
                }
            }
    */
    private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        // If node is null, there's nothing to clone
        if(node == null){
            return null;
        }
        // If we've already created a clone for this node, return it
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        // Create a new node with the same value as the original
        Node clone = new Node(node.val);
        // Save this clone in the visited map before exploring neighbors
        visited.put(node, clone);
        //For each neighbor, we call cloneGraph(neighbor). If that neighbor hasn’t yet been cloned, the recursive call will allocate a new Node, put it in the visited map, then (in turn) clone its neighbors. If it has already been cloned, the map lookup immediately returns the existing clone, so we don’t duplicate nodes or get stuck in a cycle.
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}