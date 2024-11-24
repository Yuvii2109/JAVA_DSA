import java.util.ArrayList;

public class MultiDimensionalArrayList {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        innerList1.add(2);
        mainList.add(innerList1);
        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(3);
        innerList2.add(4);
        mainList.add(innerList2);
        for(int i = 0; i < mainList.size(); i++){
            ArrayList<Integer> currentList = mainList.get(i);
            for(int j = 0; j < currentList.size(); j++){
                System.out.print(currentList.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(mainList);
    }
}