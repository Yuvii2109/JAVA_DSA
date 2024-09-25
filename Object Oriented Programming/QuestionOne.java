public class QuestionOne{
    public static void main(String[] args) {
        Student s = new Student();
        // s->name = "Yuvraj"; - Wrong method (Cpp main chlega yeh) no arrow operator in Java
        // Student.name = "Aman"; - Only applicable if Student class is public
        s.name = "Aman"; // Correct method
    }
}
class Student{
    String name;
    int marks;
}

//----------------------------------------------- //

class Person{
    String name;
    int age;
}
class Member extends Person{
    int id;
    String department;
}
// Here Person is the base class and Member is the derived class 
// class Person can access the variables - name and age and not id and department
// But class Member can access all the variables 

//----------------------------------------------- //

// private and protected access modifiers are not allowed in front of class

//----------------------------------------------- //

class Vehicle{}
class Car extends Vehicle{}
// Ab main function main hm yeh sb daal skte hain - 
// Car c = new Car();
// Vehicle v = new Vehicle();
// Vehicle v = new Car(); // Upcasting - Agr Vehicle class ko ek set maan len toh 
// Vehicle set is a subset of the Car set isliye koi problem nahi aayegi
// Car c = new Vehicle(); // Downcasting - Runtime Error kyuki Car set is the superset of Vehicle