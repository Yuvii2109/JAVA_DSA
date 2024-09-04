public class Arrayupdation {
    public static void update(int marks[]){
        for(int i = 0; i < marks.length; i++){
            marks[i] += 1;
        }
    }
    public static void main(String args[]){
        int marks[] = {84,93,100};
        update(marks);
        System.out.println();
        for(int i = 0; i < marks.length; i++){
            System.out.println(marks[i]);
        }
        System.out.println();
    }
}