import java.util.PriorityQueue;

public class PQForObjects {
    // Defines a Student class nested within the PQForObjects class.
    // Implements Comparable<Student> -
    // The Comparable interface allows Student objects to be compared with 
    // each other, which is required for the PriorityQueue to determine 
    // their ordering.
    public static class Student implements Comparable<Student>{
        String name;
        int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        // Classes ke objects ko compare krne ke liye
        @Override
        public int compareTo(Student other) {
            return this.age - other.age;    
        }
        // Defines how two Student objects are compared for ordering in 
        // the PriorityQueue.
        // Logic -
        // If this.age < other.age, the result is negative, meaning this 
        // should come first.
        // If this.age > other.age, the result is positive, meaning other 
        // should come first.
        // If this.age == other.age, the result is 0, meaning they are 
        // considered equal in terms of order.
        // This ordering logic makes the PriorityQueue a min-heap, where 
        // the Student with the smallest age is dequeued first.
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Rahul", 20));
        pq.add(new Student("Rohan", 18));
        pq.add(new Student("Rajat", 22));
        pq.add(new Student("Rahul", 20)); // Duplicate student, but different object
        while (!pq.isEmpty()) {
            Student student = pq.poll();
            System.out.println(student.name + " -> " + student.age);
        }
    }
}