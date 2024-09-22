public class Constructors {
    public static void main(String[] args) {
        Student s2 = new Student("\nYuvraj Sachdeva");
        Student s3 = new Student(21);
        System.out.println(s2.name);
        System.out.println(s3.roll);
        System.out.println();
    }
}

class Student{
    String name;
    int roll;
    Student(){
        System.out.println("\nConstructor is called...\n");
    }
    Student(String name){
        this.name = name;
    }
    Student(int roll){
        this.roll = roll;
    }
}