public class MovingXsToEnd {
    public static void moveAllX(String str, int index, int count, String newString){
        if(index == str.length()){
            for(int i = 0; i < count; i++){
                newString += "x";
            }
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(index);
        if(currentChar == 'x'){
            count++;
            moveAllX(str, index + 1, count, newString);
        }else{
            newString += currentChar;
            moveAllX(str, index+1, count, newString);
        }
    }
    public static void main(String[] args) {
        String str = "wbxxncgx";
        moveAllX(str, 0, 0, "");
    }
}