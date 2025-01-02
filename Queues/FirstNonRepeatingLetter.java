import java.util.*;

public class FirstNonRepeatingLetter {
    public static void firstNonRepeating(String str){
        int freq[] = new int[26]; // To track characters from 'a' to 'z'
        Queue<Character> q = new LinkedList<>(); // To store first non-repeating character
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++; // Increment frequency of character
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.poll(); // Remove character if it's repeating
            }
        }
        if(q.isEmpty()){
            System.out.println("No non-repeating character found\n");
        }else{
            System.out.println("First non-repeating character is - " + q.peek() + "\n");
        } 
    }
    public static void main(String args[]){
        String str = "aabcbcyuuykv";
        firstNonRepeating(str);
    }
}