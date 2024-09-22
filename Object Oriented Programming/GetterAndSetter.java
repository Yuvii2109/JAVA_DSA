public class GetterAndSetter {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println("\n" + p1.getColor());
        p1.setTip(0.5f);
        System.out.println(p1.getTip() + "\n");
    }
}

class Pen{
    private String color;
    private float tip;

    String getColor(){
        return this.color;
    }
    float getTip(){
        return this.tip;
    }

    void setColor(String newColor){
        this.color = newColor;
    }

    void setTip(float newTip){
        this.tip = newTip;
    }
}