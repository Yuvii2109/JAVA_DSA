public class StringCompression {
    public static String compressString(String str){
        StringBuilder compressed = new StringBuilder("");
        int count = 1;
        for(int i = 0; i < str.length(); i++){
            if(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                count++;
            }else{
                compressed.append(str.charAt(i));
                if(count > 1){
                    compressed.append(count);
                }else{
                    compressed.append(1);
                }
                count = 1;
            }
        }
        return compressed.toString();
    }
    public static void main(String args[]){
        String str = "aabcccccaaa";
        System.out.println("\n" + compressString(str) + "\n");
    }
}