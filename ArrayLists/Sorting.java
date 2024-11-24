import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        Collections.sort(list);
        System.out.println(list);

        // descending -
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}