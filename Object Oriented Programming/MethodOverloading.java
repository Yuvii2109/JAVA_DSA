public class MethodOverloading {
    public static void main(String args[]){
        Calculator cal = new Calculator();
        System.out.println(cal.sum(3,4));
        System.out.println(cal.sum(3,3,1));
        System.out.println(cal.sum(11.605f, 11.605f));
    }
}

class Calculator{
    int sum(int a, int b){
        return a + b;
    }
    float sum(float a, float b){
        return a + b;
    }
    int sum(int a, int b, int c){
        return a + b + c;
    }
}