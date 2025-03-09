public class DuplicateNumberInArray{
    public int findDuplicate(int[] nums) {
        // int count[] = new int[nums.length];
        // for(int i = 0; i < nums.length; i++){
        //     int num = nums[i];
        //     count[num-1]++;
        //     if(count[num-1] > 1){
        //         return num;
        //     }
        // }
        // return -1;
        // But this is taking extra space complexity so we must take help from people better than us and come up with a solution with a better time complexity that is floyd's cycle detection method/ tortoise and hare method or the slow fast pointer approach...
        int slow = nums[0], fast = nums[0];
        // Detect cycle
        do{
            slow = nums[slow]; // Slow by one step
            fast = nums[nums[fast]]; // Fast by two steps
        }while(slow != fast);

        // Find the entrance of the cycle
        slow = nums[0]; // Reset slow to the start
        while(slow != fast){
            slow = nums[slow]; // Move slow by one step
            fast = nums[fast]; // Fast also by one step
        }
        return slow; // The duplicate number
        // Explanation in notes
    }
}