import java.util.Arrays;

public class EmployeesWhoMetTheTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int n = hours.length;
        Arrays.sort(hours);
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(hours[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return n-left;
    }
}

// Again... Linear search gives a better time complexity...