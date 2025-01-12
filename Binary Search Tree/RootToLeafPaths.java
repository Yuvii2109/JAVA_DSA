// 4 paths - [8-5-3-1], [8-5-3-4], [8-5-6], [8-10-11-14]

import java.util.*;

public class RootToLeafPaths {
    public static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    public static Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(root.data > value){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }
        return root;
    }
    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null) {
            System.out.println(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1); // backtracking step
    }
    public static void main(String[] args) {
        int[] value = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        /*
         *  BST - 
         *               8
         *             /   \
         *            5     10
         *           / \      \
         *          3   6      11
         *         /  \          \ 
         *        1     4         14
         */
        Node root = null;
        for(int i = 0; i < value.length; i++){
            root = insert(root, value[i]);
        }
        ArrayList<Integer> path = new ArrayList<>();
        printRootToLeaf(root, path);
    }
}

/*
    The printRootToLeaf method is called recursively with the root 
    node and an empty path list. Here's the traversal flow -

    Start at 8, add it to the path: [8].
    Traverse left to 5, add it - [8, 5].
    Traverse left to 3, add it - [8, 5, 3].
    Traverse left to 1, add it - [8, 5, 3, 1].
    Leaf Node - Print [8, 5, 3, 1].

    Backtrack to 3 (path becomes [8, 5, 3]).
    Traverse right to 4, add it - [8, 5, 3, 4].
    Leaf Node - Print [8, 5, 3, 4].

    Backtrack to 5 (path becomes [8, 5]).
    Traverse right to 6, add it - [8, 5, 6].
    Leaf Node: Print [8, 5, 6].

    Backtrack to 8 (path becomes [8]).
    Traverse right to 10, add it - [8, 10].
    Traverse right to 11, add it - [8, 10, 11].
    Traverse right to 14, add it - [8, 10, 11, 14].
    Leaf Node - Print [8, 10, 11, 14].
    Backtrack to 8 (path becomes empty).
*/