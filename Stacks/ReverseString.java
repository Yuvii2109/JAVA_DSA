import java.util.*;

public class ReverseString {
    public static void reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        str = result.toString();
        System.out.println(str);
    }
    public static void main(String args[]){
        reverseString("Yuvraj");
    }
}