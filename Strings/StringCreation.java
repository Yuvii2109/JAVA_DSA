public class StringCreation {
    public static void main(String args[]){
        char arr[] = {'a', 'b', 'c', 'd'};
        String str1 = "abcd";
        String str2 = new String("abcd");
        String str3 = new String(arr);
        System.out.println();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println();
        // Strings are IMMUTABLE - Change nahi ho skte...
    }
}