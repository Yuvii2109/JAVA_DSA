import java.util.*;

public class Anagrams {
    public static void main(String args[]){
        String str1 = "listen";
        String str2 = "silent";
        
        // Converting the string to lowercase so that we don't have to check separately
        str1  = str1.toLowerCase();
        str2  = str2.toLowerCase();

        // Comparing the lengths
        if (str1.length() == str2.length()){
            // Converting the string to character array
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            // Sorting the character array
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            // Comparing the sorted arrays
            if(Arrays.equals(arr1, arr2)){
                System.out.println("\nThe strings are anagrams\n");
            }else{
                System.out.println("\nThe strings are not anagrams\n");
            }
        }else{
            System.out.println("\nThe strings are not anagrams\n");
        }
    }
}