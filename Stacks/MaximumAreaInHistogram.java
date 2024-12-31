import java.util.*;

// Given an array of integers which represent the dimension of the histogram's
// bars, return the area of the largest rectangle in the histogram. Provided
// that the histogram's bars have width 1.

public class MaximumAreaInHistogram {
    public static void maxArea(int[] arr){
        int maxArea = 0;
        int n = arr.length;
        int nextSmallerRight[] = new int[n];
        int nextSmallerLeft[] = new int[n];

        // Next Smaller Right - NextGreater main zra se change krne par nikl jayega
        Stack<Integer> s = new Stack<Integer>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextSmallerRight[i] = n;
                // yeh isliye hua kyunki agar right main kuch smallest hai hi nahi
                // toh vo smallest hoga poore height main isliye vo last tak jaa sakta hai
                // For example for the height of 1... the rectangle can be formed with a width
                // equal to the length of the array which is n
            }else{
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }

        // Next Smaller Left -
        s = new Stack<Integer>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextSmallerLeft[i] = -1;
                // Ab yaar chronology samjho na!!! yeh boht logical hai...
                // dry run krle bhai zyda baat hai toh... 
            }else{
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        // Current area => (width = nextSmallerRight[i] - nextSmallerLeft[i] - 1)*height
        // Ab yu ki yeh kyu hua??? The reason behind this is that hmara current bar
        // apni height compromise kyu krna chahega height bdhane ke liye haina... 
        // Toh humne yeh avoid krne ke liye kya kra ki... humne current bar toh liya hi
        // ab hum iski right side par isse choti value ko find krenge or similarly for the
        // left side... toh ek example lekr smjhte hain... suppose hum abhi apne 5 height ke
        // bar par hain... ab hum iski just right side dekhen toh... 6 height ka bar hai
        // toh vo toh area main contribute hi krega na... but agar hm 6 ke right main dekhen 
        // toh 2 height ka bar hai... ab agar hum 2 height ke bar ko include krna chahen toh hmare
        // liye area ka loss ho jayega na... isliye hum 2 height ko avoid krenge... similarly for 
        // the left side... toh ab isse hmari width nikal jayegi na... 
        // which is || width = nextSmallerRight[i] - nextSmallerLeft[i] - 1 ||
        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            System.out.println("NSR " + (i+1) + " - " + nextSmallerRight[i]);
            System.out.println("NSL " + (i+1) + " - " + nextSmallerLeft[i]);
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currentArea = height*width;
            System.out.println("Current area " + (i+1) + " - " + currentArea + "\n");
            maxArea = Math.max(maxArea, currentArea);
        }
        System.out.println("Maximum area in histogram - " + maxArea);
    }
    public static void main(String args[]){
        int[] histogram = {2, 1, 5, 6, 2, 3};
        maxArea(histogram);
    }
}

// Linear time complexity - O(n)