public class Hierarchial {
    public static void main(String args[]){
        Reptile snakes = new Reptile();
        snakes.name = "Python"; // Btao java main bhi python daal di
        System.out.println("Name of the reptile is - " + snakes.name);
        snakes.eats();
        Mammal whale = new Mammal();
        whale.name = "Blue Whale";
        System.out.println("Name of the whale - " + whale.name);
        whale.breathes();
    }
}
// Base Class
class Animal{
    String name;
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
    void walk(){
        System.out.println("Walking");
    }
}
class Reptile extends Animal{
    void scales(){
        System.out.println("Scales");
    }
}
class Bird extends Animal{
    void fly(){
        System.out.println("Flying");
    }
}
class Amphibian extends Animal{
    void swim(){
        System.out.println("Swimming");
    }
}