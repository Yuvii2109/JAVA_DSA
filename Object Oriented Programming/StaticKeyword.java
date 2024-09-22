public class StaticKeyword {
    public static void main(String[] args) {
        // Student s1 = new Student();
        // s1.collegeName = "MAIT";
        // System.out.println(s1.collegeName); // prints MAIT
        // Student s2 = new Student();
        // System.out.println(s2.collegeName); // also prints MAIT because collegeName is static
    }
}

class Student {
    String name;
    int roll;
    static String collegeName; // static variable shared across all instances of Student
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}