import java.util.*;

public class Challenge_18 {

    // Function to find the number of divisors of n
    public static int findDivisors(int n) {
        int count = 0;

        // Loop runs till √n to find divisor pairs
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i is a divisor
                if (i != n / i) {
                    count++; // n / i is also a divisor unless it's a square
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Number:");
        int n = s.nextInt();

        System.out.println("Number of divisors: " + findDivisors(n));
        s.close(); // Close the scanner
    }
}
