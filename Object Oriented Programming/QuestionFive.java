public class QuestionFive {
    public static void main(String args[]){
        Test t = new Test();
        t.setMarks(100);
        System.out.println(Test.marks);
    }
}
class Test{
    static int marks;
    void setMarks(int marks){
        // this.marks = marks;
    }
}

// No error...