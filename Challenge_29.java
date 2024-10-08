import java.util.Scanner;

public class Challenge_29 {

    // Function to compute the n-th Fibonacci number using dynamic programming
    public static long fibonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Create an array to store Fibonacci numbers
        long[] fib = new long[n + 1];
        fib[0] = 0; // F(0)
        fib[1] = 1; // F(1)

        // Fill the array using the bottom-up approach
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n]; // Return the n-th Fibonacci number
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a non-negative integer n (0 ≤ n ≤ 1000):");
        int n = scanner.nextInt();

        // Input validation
        if (n < 0 || n > 1000) {
            System.out.println("Invalid input. Please enter a number between 0 and 1000.");
        } else {
            long result = fibonacci(n);
            System.out.println("Fibonacci number F(" + n + ") = " + result);
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
