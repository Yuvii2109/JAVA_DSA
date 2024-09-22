public class Interface {
    public static void main(String args[]){
        Queen q = new Queen();
        q.moves(); 
    }
}
interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        // Ab public kyu kara... Vo isliye kyuki agar nahi krte toh default ho jaata
        System.out.println("Queen can move in any direction");
    }
}