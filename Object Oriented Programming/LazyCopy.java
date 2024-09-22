public class LazyCopy {
    public static void main(String[] args) {  
        Student s1 = new Student();
        s1.name = "John";
        s1.roll = 1;
        s1.marks = new int[]{100, 90, 80}; // Initialize marks array
        s1.password = "abcd";

        // Create a shallow copy (lazy copy)
        Student s2 = new Student(s1);

        // Print original s2 details
        System.out.println(s2.name + " " + s2.roll);
        
        // Modify s2
        s2.password = "newPass";
        s2.marks[2] = 95;

        // Print both s1 and s2 details after modification
        System.out.println("s1 password: " + s1.password);
        System.out.println("s2 password: " + s2.password);

        System.out.println("s1 marks:");
        for (int i = 0; i < 3; i++) {
            System.out.println(s1.marks[i]);
        }

        System.out.println("s2 marks:");
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }
    }
}
class Student {
    String name;
    int roll;
    String password;
    int[] marks; // Array declaration
    
    // Shallow Copy Constructor (Lazy Copy)
    Student(Student s1) {
        this.name = s1.name;
        this.roll = s1.roll;
        this.password = s1.password;
        this.marks = s1.marks; // Shallow copy of the array (just copying reference)
    }

    // Default constructor
    Student() {
        marks = new int[3]; // Initialize marks array with size 3
    }
}