// The expression -~x will add 1 to an integer x. We know that to get negative of
// a number, invert its bits and add 1 to it (negative numbers are stored in 2’s
// complement form), i.e., 
// -x = ~x + 1; => -~x = x + 1;

public class AddingOne {
    public static void main(String args[]){
        int x = 22; 
        System.out.println("\n" + x + " + 1 = " + -~x);
        int y = -22;
        System.out.println(y + " + 1 = " + -~y);
        int z = 0;
        System.out.println(z + " + 1 = " + -~z + "\n");
    }
}