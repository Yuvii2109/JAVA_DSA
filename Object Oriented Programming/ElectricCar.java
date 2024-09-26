class Automobile{
    @SuppressWarnings("unused")
    private String drive(){
        return "Driving Vehicle";
    }
}
class Car extends Automobile{
    protected String drive(){
        return "Driving Car";
    }
}
public class ElectricCar extends Car{
    @Override
    public final String drive(){
        return "Driving Electric Car";
    }
    public static void main(String[] wheels){
        final Car car = new ElectricCar();
        System.out.println(car.drive());
    }
}
// The drive() method in the Car class does not override the version 
// in the Automobile class since the method is not visible to the Car class.
// The drive() method in the Electric Car class is a valid override of 
// the method in the Car class, with the access modifier expanding in the 
// subclass. For these reasons, the code compiles.
// In the main() method, the object created is an Electric Car, even if it
// is assigned to a Car reference. Due to polymorphism, the method from 
// the Electric Car will be invoked giving the output - Driving Electric Car

// final is used to indicate that the method drive() in the ElectricCar class cannot be overridden by any subclass. 