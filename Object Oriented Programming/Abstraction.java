public class Abstraction {
    public static void main(String args[]){
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color); // Brown aayega kyuki class se pehle 
        // Super class call ho rhi hai... 
        Chicken c = new Chicken();
        c.eat();
        c.walk();
        System.out.println(c.color); // Brown aayega kyuki class se pehle 
        // Super class call ho rhi hai... 
    }
}
abstract class Animal{
    String color;
    Animal(){
        System.out.println("Animal is created");
        color = "brown";
    }
    void eat(){
        System.out.println("Eating...");
    }
    abstract void walk();
}
class Horse extends Animal{
    Horse(){
        System.out.println("Horse is created");
    }
    // Ab dekhoge toh Horse ke neeche red line aagyi hai
    // Kyunki yahaan par abstract method ka implementation nahi kiya hai
    // Abhi tak to sirf declaration ki hai
    // Toh walk ko implement krna Horse ke liye compulsory hogya hai 
    void walk(){
        System.out.println("Horse is walking");
    }
    void changeColor(){
        color = "white";
    }
}
class Pegasus extends Horse{
    Pegasus(){
        System.out.println("Pegasus is created");
    }
}
class Chicken extends Animal{
    void walk(){
        System.out.println("Chicken is walking");
    }
    void changeColor(){
        color = "yellow";
    }
}