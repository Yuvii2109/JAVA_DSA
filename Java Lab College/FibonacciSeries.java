public class FibonacciSeries {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1;

        System.out.println("First 10 terms of Fibonacci series - ");

        // Print the first ten terms
        for (int i = 1; i <= 10; i++) {
            System.out.print(n1 + " ");

            // Calculate the next term
            int nextTerm = n1 + n2;

            // Update variables for the next iteration
            n1 = n2;
            n2 = nextTerm;
        }
    }
}