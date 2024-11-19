public class Permutation {
    public static void permutations(String str, String ans){
        // Base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        // Recursive case
        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            // "yuvraj" = if chatAt(i) == v => "yu" + "raj" = "yuraj"
            String remaining = str.substring(0, i) + str.substring(i+1);
            permutations(remaining, ans + current);
        }
    }
    public static void main(String[] args) {
        permutations("abc", "");
    }
}

// Time complexity of this code is -> O(n*n!) #WTH?