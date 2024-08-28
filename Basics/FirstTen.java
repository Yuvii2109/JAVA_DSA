public class FirstTen {
    public static void main(String args[]){
        int count = 1;
        System.out.print("\n");
        while (count <= 10) { 
            if(count < 10){
                System.out.print(count + ", ");
            }else{
                System.out.println(count + "\n");
            }
            count++;
        }
    }
}