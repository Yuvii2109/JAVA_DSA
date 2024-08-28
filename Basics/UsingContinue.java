public class UsingContinue {
    public static void main(String args[]){
        System.out.println("\nThis program skips multiples of 10 - ");
        for(int i=0; i<=50; i += 5){
            if(i % 10 == 0){
                continue;
            }else{
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }
}