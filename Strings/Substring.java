public class Substring {
    public static String subString(String str, int start, int end){
        String subStr = "";
        for(int i=start; i<=end; i++){
            subStr += str.charAt(i);
        }
        return subStr;
    }
    public static void main(String[] args) {
        String str = "YuvrajSachdeva";
        System.out.println("\n" + subString(str, 6, 9));

        // Yeh toh hogyi maamuli baat... huh... Lekin java main already 
        // ek aisa feature hai to do the same without declaring a function

        System.out.println("\n" + str.substring(0, 6) + "\n");
    }
}