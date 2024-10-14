public class Subsequences {
    public static void subsequences(String str, int index, String newString){
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(index);
        // To be
        subsequences(str, index+1, newString+currentChar);
        // To not be
        subsequences(str, index+1, newString);
    }
    public static void main(String[] args) {
        String str = "abc";
        subsequences(str, 0, "");
    }
}