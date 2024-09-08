public class charAtMethod {
    public static void main(String[] args) {
        String str = "Yuvraj";
        System.out.println();
        for(int i = 0; i < str.length(); i++){
            System.out.println("Character at position " + (i+1) + " - " + str.charAt(i));
        }
        System.out.println();
    }
}