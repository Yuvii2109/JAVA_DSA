// Lexicographically smallest string of length N and sum K
// We have two integers N and K. The task is to print the lexicographically 
// smallest string of length N consisting of lower-case English alphabets 
// such that the sum of the characters of the string equals to K where 
// ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, ... and ‘z’ = 26.
// Sample Input 1 - N = 5, K = 42
// Sample Output 1 - aaamz
// Sample Input 2 - N = 3, K = 25
// Sample Output 2 - aaw

public class Lexicography {
    public static String getSmallestString(int N, int K) {
        // Initialize the result with 'a' (smallest character)
        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }
        // Toh humne N elements ka array bnaya or saare indices par 'a' laga diya

        // Remaining sum after assigning 'a' to all characters
        int remainingSum = K - N;
        // Ab humne 'a' ki value ko 1 consider kra hai and since humne
        // saare indices par 'a' fill krdia hai isliye humne value se N
        // minus krdia hai

        // Traverse from the last character
        for (int i = N - 1; i >= 0 && remainingSum > 0; i--) {
            // Add as much as possible to this position (max 25)
            // Basically remainingSum or 25 main jo minimum number hai 
            // use add krdo current character main until the remainingSum
            // becomes zero value main integer add krne par jab vo finally
            // store hoga tab vo charater main cast ho jayega
            int addValue = Math.min(remainingSum, 25);
            result[i] += addValue;
            remainingSum -= addValue;
        }
        // Dry run krke dikhata hai tera bhai yaar chinta kyu krta hai?
        // result = ['a', 'a', 'a', 'a', 'a']
        // remainingSum = 42 - 5 = 37
        // starting with the rightmost character of index 4
        // index 4 -> 'a' = 1 and remainingSum = 37, now
        // Math.min(37, 25) = 25 => 'a' + 25 = 'z'
        // result = ['a', 'a', 'a', 'a', 'z']
        // remainingSum = 37 - 25 = 12
        // come back 1 character to index 3 
        // index 3 -> 'a' = 1 and remainingSum = 12, now
        // Math.min(12, 25) = 12 => 'a' + 12 = 'm'
        // result = ['a', 'a', 'a', 'm', 'z']

        
        return new String(result);
        // result = "aaamz"
    }
    public static void main(String[] args) {
        int N = 5, K = 42;
        System.out.println("Lexicographically smallest string - " + getSmallestString(N, K));
    }
}