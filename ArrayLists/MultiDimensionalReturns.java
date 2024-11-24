import java.util.ArrayList;

public class MultiDimensionalReturns {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            list1.add(i*1); // 1 2 3 
            list2.add(i*2); // 2 4 6 
            list3.add(i*3); // 3 6 9 
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);
        for(int i = 0; i < mainList.size(); i++){
            ArrayList<Integer> currentList = mainList.get(i);
            for(int j = 0; j < currentList.size(); j++){
                System.out.print(currentList.get(j) + " ");
            }
            System.out.println();
        }
    }
}