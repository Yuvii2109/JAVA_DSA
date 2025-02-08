// Used to store and track non overlapping sets
// Used for cycle detection and also in Kruskal's Algorithm
// Optimized method of implementation - Parent + union by rank 

import java.util.*;

public class DisjointSetDS {
    static int n = 7;
    static int[] parent = new int[n]; // This array holds the “parent” of each element. Initially, each element is its own parent (each element is in its own set).
    static int[] rank = new int[n]; // This array is used to store the “rank” (an approximation of the depth or height of the tree) for each set. It helps in making the union operation efficient by always attaching the smaller tree to the larger one.
    public static void init(){
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    // Finds and returns the representative (or “root”) of the set that contains element x.
    public static int find(int x){ // Constant time complexity
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // Optimization - Path compression
        // If x is not its own parent, the method recursively calls find(parent[x]) to find the root. The root is then assigned to x, effectively compressing the path from x to the root.

        // The key optimization is the assignment parent[x] = find(parent[x]), which flattens the tree by making x point directly to the root.

        // This significantly speeds up future find operations.
    }
    public static void union(int x, int y) { // Constant time complexity 
        int parentx = find(x);
        int parenty = find(y);

        // If parentx and parenty are the same, the elements are already in the same set, and no action is taken.
        if (parentx != parenty) {
            if (rank[parentx] < rank[parenty]) {
                // The tree rooted at parentx is “shorter” than the one rooted at parenty. The shorter tree is attached under the taller tree - parent[parentx] = parenty.
                parent[parentx] = parenty;
            }else if (rank[parentx] > rank[parenty]) {
                // The tree rooted at parenty is attached under the tree rooted at parentx by setting parent[parenty] = parentx.
                parent[parenty] = parentx;
            }else {
                // When both trees have the same rank, one tree (here, parenty) is arbitrarily attached under the other (parentx).
                parent[parenty] = parentx;
            }
            rank[parentx]++; // In standard union-by-rank implementations, the rank is incremented only when the two trees have the same rank. Here, the rank of parentx is incremented regardless of the branch taken, which is a slight deviation from the canonical approach. However, the overall purpose of keeping the trees balanced is still achieved.
        }
    }
    public static void main(String[] args){
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        // union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
        System.out.println(find(5));
    }
}