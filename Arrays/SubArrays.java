public class SubArrays {
    public static void printSubarray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k]);
                }
                if(j < arr.length-1){
                    System.out.print(", ");
                }else{
                    System.out.print("");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println();
        printSubarray(arr);
        System.out.println();
    }
}