public class ClassesAndObjects{
    public static void main(String[] args) {
        // Creating a Pen object of the class
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println("\n" + p1.color);
        p1.setTip(0.5f);
        System.out.println(p1.tip + "\n");

    }
}

class Pen{
    String color;
    float tip;

    void setColor(String newColor){
        color = newColor;
    }

    void setTip(float newTip){
        tip = newTip;
    }
}

class Student{
    String name;
    int age;
    float percentage;
    void calculatePercentage(int phy, int chem, int math){
        percentage = (phy + chem + math)/3;
    }
}