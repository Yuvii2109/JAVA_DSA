public class Inheritance {
    public static void main(String args[]){
        Fish shark = new Fish();
        System.out.println();
        shark.eats();
        System.out.println();
    }
}

// Base Class (Parent Class)
class Animal{
    String color;
    void eats(){
        System.out.println("Eating");
    }
    void breathes(){
        System.out.println("Breathing");
    }
}
// Derived Class (Child Class)
class Fish extends Animal{
    void swims(){
        System.out.println("Swimming");
    }
    int fins;
}