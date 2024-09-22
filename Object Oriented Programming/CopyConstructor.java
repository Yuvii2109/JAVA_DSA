public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "John";
        s1.roll = 1;
        Student s2 = new Student(s1);
        System.out.println(s2.name + " " + s2.roll);
        System.out.println();
    }
}
class Student{
    String name;
    int roll;
    String password;
    int[] marks;
    // Shallow Copy Constructor
    Student(Student s1){
        this.name = s1.name;
        this.roll = s1.roll;
    }
    Student(){
        System.out.println("\nConstructor");
    }
}