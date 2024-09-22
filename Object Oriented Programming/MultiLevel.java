public class MultiLevel {
    public static void main(String args[]){
        Lion shera = new Lion();
        shera.eats();
        shera.limbs = 4;
        shera.maneColor = "golden";
        System.out.println(shera.limbs);
        System.out.println(shera.maneColor);
    }
}

// Base Class
class Animal{
    String color;
    void eats(){
        System.out.println("Eating");
    }
    void breathes(){
        System.out.println("Breathing");
    }
}
// Derived Class
class Mammal extends Animal{
    int limbs;
}
// Derived Class
class Lion extends Mammal{
    String maneColor;
}