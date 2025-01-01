import java.util.Stack;

public class TrappingTheRainWater {
    public static int maxWater(int[] height) {
        // Handle edge cases
        if (height == null || height.length < 3) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int poppedHeight = height[stack.pop()];
                // While the stack is not empty and the current bar height 
                // is greater than the height of the bar at the top of the 
                // stack:
                // Pop the top of the stack, which represents the "bottom" 
                // of the trapped water area.
                // poppedHeight is the height of this bottom bar.

                if (stack.isEmpty()) {
                    break;
                }
                // If the stack becomes empty after popping, it means 
                // there's no left boundary, so break the loop.

                // Calculate distance and bounded height
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[stack.peek()], height[i]) - poppedHeight;
                // The distance between the current bar and the new top 
                // of the stack is -> i - stack.peek() - 1
                // This represents the width of the trapped water segment.
                // The bounded height is determined by the shorter of the 
                // left (height[stack.peek()]) and right (height[i]) boundaries, 
                // minus the height of the popped bar (poppedHeight).

                // Add trapped water for this segment
                ans += distance * boundedHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 6};
        System.out.println("Total trapped water: " + maxWater(arr));
    }
}

// Linear Time Complexity - O(n)