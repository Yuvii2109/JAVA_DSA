import java.util.ArrayList;

public class Implementation {
    public static void main(String args[]){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        list1.add(1); // O(1) - add operation
        list1.add(2);
        list2.add("Yuvraj");
        list2.add("Sachdeva");
        list3.add(true);
        list3.add(false);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        String element1 = list2.get(1); // O(1) - get operation
        int element2 = list1.get(0);
        boolean element3 = list3.get(1);
        System.out.println(element1);
        System.out.println(element2);
        System.out.println(element3);

        list1.remove(1); // O(n) - remove operation 
        System.out.println(list1);

        list3.set(1, true); // O(n) - set element at index operation
        System.out.println(list3);

        // O(n) - contains element operation
        System.out.println(list2.contains("Sachdeva")); 
        System.out.println(list3.contains(false));
        System.out.println(list3.contains(true));

        // O(n) - Index addition 
        list1.add(0, 23);
        System.out.println(list1);

        // Printing the size of an array list 
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());

        // Printing the array list 
        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < list2.size(); i++){
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < list3.size(); i++){
            System.out.print(list3.get(i) + " ");
        }
        System.out.println();

        // Printing the AL in reverse
        for(int i = list1.size() - 1; i >= 0; i--){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
    }
}