import java.util.Scanner;

public class ShortestDistance {
    public static void shortestDistance(String str){
        int n = str.length();
        int x = 0; 
        int y = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'N' || str.charAt(i) == 'n'){
                // North
                y++;
            }else if(str.charAt(i) == 'S' || str.charAt(i) == 's'){
                // South
                y--;
            }else if(str.charAt(i) == 'E' || str.charAt(i) == 'e'){
                // East
                x++;
            }else if(str.charAt(i) == 'W' || str.charAt(i) == 'w'){
                // West
                x--;
            }else{
                continue;
            }
        }
        int xSquare = x*x;
        int ySquare = y*y;
        float shortestDistance = (float)Math.sqrt(xSquare + ySquare);
        System.out.println("\nShortest Distance - " + shortestDistance + "\n");
    }
    public static void main(String args[]){
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the directions in the form of (N-E-W-S) - ");
        str = sc.nextLine();
        shortestDistance(str);
        sc.close();
    }
}