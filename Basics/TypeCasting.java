public class TypeCasting {
    public static void main(String args[]){
        // Explicit Casting
        int i = 10;
        double d = (double)i; // Explicit Casting from int to double
        System.out.println("Explicit Casting: " + d);
        // Implicit Casting
        double d1 = 10.5;
        int i1 = (int)d1; // Implicit Casting from double to int
        System.out.println("Implicit Casting: " + i1);
    }
}