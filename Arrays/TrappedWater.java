public class TrappedWater {
    public static void waterTrap(int arr[]) {
        int n = arr.length;

        // Finding out the leftMax boundary
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        // Finding out the rightMax boundary
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }

        // Making a loop
        int trappedWater = 0;
        for(int i = 0; i < n; i++){
            // waterlevel = Math.min(leftMax, rightMax);
            // trapped water += waterlevel - arr[];
            trappedWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        System.out.println("\nTrapped water is " + trappedWater + " square units\n");
    }
    public static void main(String args[]){
        int height[] = {4,2,0,3,2,5};
        waterTrap(height);
    }
}