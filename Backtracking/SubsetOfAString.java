public class SubsetOfAString {
    public static void findSubsets(String str, String ans, int i){
        // Base Case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("Empty Set");
            }else{
                System.out.println(ans);
            }
            return;
        }
        // Yes Choice
        findSubsets(str, ans + str.charAt(i), i+1);
        // No Choice
        findSubsets(str, ans, i+1);
    }
    public static void main(String args[]){
        findSubsets("abc", "", 0);
    }
}

// Time complexity of this code is - O(n*2^n)