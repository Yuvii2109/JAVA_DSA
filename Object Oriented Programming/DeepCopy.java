public class DeepCopy {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "John";
        s1.roll = 1;
        s1.marks = new int[3];
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        s1.password = "abcd";
        Student s2 = new Student(s1);
        System.out.println(s2.name + " " + s2.roll);
        s2.password = "yuvii";
        s1.marks[2] = 93; // changing s1.marks[2] will not change the output but
        // changing s2.marks[2] will change the output
        System.out.println(s2.password);
        for(int i = 0; i < 3; i++){
            System.out.println(s2.marks[i]);
        }
        System.out.println();
    }
}
class Student{
    String name;
    int roll;
    String password;
    int[] marks;
    // Deep Copy Constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i = 0; i < marks.length; i++){
            this.marks[i] = s1.marks[i];
        }
    }
    Student(){
        System.out.println("\nConstructor");
    }
}