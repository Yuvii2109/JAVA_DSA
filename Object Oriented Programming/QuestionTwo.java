public class QuestionTwo {
    public static void main(String args[]){
        Vehicle obj1 = new Car();
        obj1.print();
        Vehicle obj2 = new Vehicle();
        obj2.print();
    }
}
class Vehicle{
    void print(){
        System.out.println("Base Class (Vehicle)");
    }
}
class Car extends Vehicle{
    void print(){
        System.out.println("Derived Class (Car)");
    }
}

// Output -
// Derived Class (Car)
// Base Class (Vehicle)

//----------------------------------------------- //

// Components of OOPS are - _
// 1. Inheritance            |
// 2. Encapsulation          |  -> 4 Pillars 
// 3. Abstraction            |   of OOPS 
// 4. Polymorphism          _|    