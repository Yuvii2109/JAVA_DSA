public class Complex {
    public static void main(String args[]){
        ComplexNum c = new ComplexNum(4,5);
        ComplexNum d = new ComplexNum(9,4);
        ComplexNum e = ComplexNum.add(c,d);
        ComplexNum f = ComplexNum.diff(c,d);
        ComplexNum g = ComplexNum.product(c,d);
        e.printComplex();
        f.printComplex();
        g.printComplex();
    }
}
class ComplexNum{
    int real;
    int imag;
    public ComplexNum(int r, int i){
        real = r;
        imag = i;
    }
    public static ComplexNum add(ComplexNum a, ComplexNum b){
        return new ComplexNum((a.real + b.real), (a.imag + b.imag));
    }
    public static ComplexNum diff(ComplexNum a, ComplexNum b){
        return new ComplexNum((a.real - b.real), (a.imag - b.imag));
    }
    public static ComplexNum product(ComplexNum a, ComplexNum b){
        return new ComplexNum((a.real * b.real - a.imag * b.imag), (a.real * b.imag + a.imag * b.real));
    }
    public void printComplex(){
        if(real == 0 && imag != 0){
            System.out.println("i" + imag);
        }else if(real != 0 && imag == 0){
            System.out.println(real);
        }else{
            System.out.println(real + " + " + imag + "i");
        }
    }
}