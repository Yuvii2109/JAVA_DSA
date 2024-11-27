import java.util.ArrayList;

public class Monotonic {
    // Ab poochoge what is monotonic -
    // A sequence is monotonic if it is either monotonically increasing or monotonically decreasing
    // A sequence is monotonically increasing if each term is greater than or equal to the previous
    // A sequence is monotonically decreasing if each term is less than or equal to the previous
    public static boolean isMonotonic(ArrayList<Integer> list){
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                isIncreasing = false;
            }else if(list.get(i) < list.get(i+1)){
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        System.out.println(isMonotonic(list));
    }
}