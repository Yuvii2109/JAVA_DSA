import java.util.ArrayList;
import java.util.Collections;

public class PairSumOne{

    // Brute Force
    public static boolean pairSumOne(ArrayList<Integer> list, int target){
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    // 2 - pointer approach -> pre-requisite -> list should be sorted in ascending order
    public static boolean pairSumOneOptimised(ArrayList<Integer> list, int target){
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        while(left != right){
            int sum = list.get(left) + list.get(right);
            if(sum == target){
                return true;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
        System.out.println(pairSumOne(list, target));
        System.out.println(pairSumOneOptimised(list, target));
    }
}