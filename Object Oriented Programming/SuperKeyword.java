public class SuperKeyword {
    public static void main(String[] args) {
        // Horse h = new Horse();
    }
}
class Animal{
    Animal(){
        System.out.println("Animal Constructor");
    }
}
class Horse extends Animal{
    Horse(){
        super(); // agar na likho toh by default likhdia jaata hai by java
        System.out.println("Horse Constructor");
    }
}