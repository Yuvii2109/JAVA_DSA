import java.util.HashSet;

public class UnionAndIntersectionOfTwoArrays {
    public static HashSet<Integer> union(int arr1[], int arr2[]){
        HashSet<Integer> union = new HashSet<>();
        int n = arr1.length;
        int m = arr2.length;
        for(int i = 0; i < n; i++){
            union.add(arr1[i]);
        }
        for(int i = 0; i < m; i++){
            union.add(arr2[i]);
        }
        return union;
    }
    
    public static HashSet<Integer> intersection(int arr1[], int arr2[]){
        HashSet<Integer> intersection = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr1){
            set.add(num);
        }
        for(int num : arr2){
            if(set.contains(num)){
                intersection.add(num);
            }
        }
        return intersection;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        
        System.out.println("Union - " + union(arr1, arr2));
        System.out.println("Intersection - " + intersection(arr1, arr2));
    }
}

// Time complexity - O(n+m)