public class RainwaterTrapping {
    public static void Rainwater(int arr[]){
        int n = arr.length;
        // calculate leftmax boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        // calculate rightmax boundary - array
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        // loop
        for(int i = 0; i < n; i++){
            // waterlevel = min(leftmax boundary, rightmax boundary)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            // trapped water = waterlevel - height[i]
            trappedWater += waterlevel - arr[i];
        }
        System.out.println("\nTrapped water is " + trappedWater + " square unit\n");
    }
    public static void main(String args[]){
        int height[] = {4,2,0,6,3,2,5};
        Rainwater(height);
    }
}

// khushi ki baat toh yeh hai ki iska O(n) hai..!!!