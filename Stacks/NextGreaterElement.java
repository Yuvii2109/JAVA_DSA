import java.util.*;

public class NextGreaterElement {
    // Agar current ke right main koi usse greater exist krta hai toh 
    // current pr vo greater element store ho jayega vrna agr uske right
    // main koi greater element nhi exist krta hai toh current pr -1 store ho jayega
    public static void main(String args[]){
        int arr[] = {23, 16, 5, 21, 19};
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] nextGreater = new int[n];

        // Dekho yaar ab 2 methods hain... ek ki hum element of the array ko
        // stack main push krte rhen ya phir doosra ki hum element of the array
        // ke index ko stack main push krte rhen... 

        // Method - 1
        // for(int i = n-1; i >= 0; i--){
        //     while(!s.isEmpty() && s.peek() <= arr[i]) {
        //         s.pop();
        //     }
        //     if(s.isEmpty()) {
        //         nextGreater[i] = -1;
        //     }else{
        //         nextGreater[i] = s.peek();
        //     }
        //     s.push(arr[i]);
        // }

        // Method - 2
        // Mai iss wale ko prefer karoonga kyunki mujhe lagta hai ki track
        // krne ke liye index ko push krna better hoga pta nahi kyu but yeah
        for(int i = n-1; i >= 0; i--){
            // Jab tak hmara stack khaali nahi ho jaata or jab tak stack ka
            // top element array ke current element se chota aa raha hota hai
            // tab tak hum us element ko stack se pop krte rhenge
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // Ab agar pop krte krte stack empty ho jaata hai toh matlab yeh
            // hai ki current element ke right main koi bhi element usse bada
            // nhi hai toh hum current element pr -1 store kr denge varna
            // hum current element pr stack ka top element store kr denge because
            // as per the above while loop... stack ka top element current element 
            // se bada hai
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }

            // Index ko push bhi toh krte rehna hai na bhaiii!!!
            s.push(i);
        }

        System.out.println("Entered array - ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Next greater array - ");
        for(int i = 0; i < n; i++){
            System.out.print(nextGreater[i] + " ");
        }
    }
}

// Linear Time Complexity - O(n)