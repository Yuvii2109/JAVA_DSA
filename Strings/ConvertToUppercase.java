public class ConvertToUppercase {
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == ' ' && i < str.length() - 1){
                sb.append(str.charAt(i));
                i++;
                ch = Character.toUpperCase(str.charAt(i));
                sb.append(ch);
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString(); // StringBuilder return nahi kr skte String ke liye
        // Kyunki StringBuilder String nahi hota... 
    }
    public static void main(String args[]){
        String str = "hi, my name is yuvraj sachdeva";
        System.out.println("\n" + toUpperCase(str) + "\n");
    }
}