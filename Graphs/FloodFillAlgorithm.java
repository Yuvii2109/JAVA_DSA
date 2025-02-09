// You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill -
// Begin with the starting pixel and change its color to color.
// Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
// Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
// The process stops when there are no more adjacent pixels of the original color to update.
// Return the modified image after performing the flood fill.

// Input - image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
// Output - [[2,2,2],[2,2,0],[2,0,1]]

import java.util.Arrays;

public class FloodFillAlgorithm {
    // sr - starting row, sc - starting column 
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        if (image[sr][sc] == color) return image; // If the starting pixel already has the new color, no need to proceed
        
        boolean visited[][] = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], color, visited);
        return image;
    }
    
    // DFS - depth-first search function to perform flood fill operation
    public void dfs(int[][] image, int r, int c, int originalColor, int color, boolean[][] visited){
        // Check if the current pixel is within the grid and has not been visited before
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || visited[r][c] || image[r][c] != originalColor){
            return;
        }
        
        // Mark the current pixel as visited
        visited[r][c] = true;
        
        // Update the color of the current pixel
        image[r][c] = color;
        
        // Recursively perform DFS on the adjacent pixels
        dfs(image, r-1, c, originalColor, color, visited); // up
        dfs(image, r+1, c, originalColor, color, visited); // down
        dfs(image, r, c-1, originalColor, color, visited); // left
        dfs(image, r, c+1, originalColor, color, visited); // right
    }
    
    public static void main(String[] args) {
        FloodFillAlgorithm obj = new FloodFillAlgorithm();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        
        System.out.println("Original Image -");
        printImage(image);
        
        int[][] result = obj.floodFill(image, sr, sc, newColor);
        
        System.out.println("\nModified Image after Flood Fill -");
        printImage(result);
    }
    
    // Utility function to print the image
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}

// Time Complexity - O(M*N)