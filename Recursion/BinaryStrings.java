public class BinaryStrings {
    // To print all binary strings of size N without consecutive 1s
    // printBinaryString(int n, int lastPlace, String str) - This method takes 
    // three parameters -
    // n - Remaining length of the binary string to generate.
    // lastPlace - Indicates whether the last appended digit was '0' or 
    // '1' (0 for '0', 1 for '1').
    // str - Current string being built up.
    public static void printBinaryString(int n, int lastPlace, String str){
        // Base Case -
        // if (n == 0) - When n reaches 0, it means we have generated a 
        // binary string of length n, so we print str.
        if(n == 0){
            System.out.println(str);
            return;
        }

        // Recursive Calls -
        // printBinaryString(n - 1, 0, str + "0") - Recursively generates 
        // binary strings of length n-1 by appending '0' to str.
        // if (lastPlace == 0) { printBinaryString(n - 1, 1, str + "1"); } -
        // If lastPlace is 0 (meaning the last digit added was '0'), it appends 
        // '1' to str and recursively generates binary strings of length n-1.
        // if(lastPlace == 0){
        //     // If 0 is positioned at the last place
        //     printBinaryString(n-1, 0, str+"0");
        //     printBinaryString(n-1, 1, str+"1");
        // }else{
        //     // If 1 is positioned at the last place
        //     printBinaryString(n-1, 0, str+"0");
        // } Ab apun ise or bdiya treeke se likhega ekdum kejually
        printBinaryString(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinaryString(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args) {
        printBinaryString(4, 0, "");
    }
}