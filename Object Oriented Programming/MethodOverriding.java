public class MethodOverriding {
    public static void main(String args[]){
        Deer sambar = new Deer();
        // Child class ka bnayege toh child class wala hi call krega
        sambar.eats();
        Animal lion = new Animal();
        lion.eats();
    }
}
class Animal{
    void eats(){
        System.out.println("Animal eats");
    }
}
class Deer extends Animal{
    void eats(){
        System.out.println("Deer eats");
    }
}