import java.util.Scanner;

public class Challenge_16 {

    // Function to calculate GCD using the Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using the formula: LCM(N, M) = (N * M) / GCD(N, M)
    public static long lcm(long N, long M) {
        return (N * M) / gcd(N, M);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input two integers
        System.out.println("Enter two integers N and M:");
        long N = scanner.nextLong();
        long M = scanner.nextLong();
        
        // Output the LCM
        System.out.println("LCM of " + N + " and " + M + " is: " + lcm(N, M));
        
        scanner.close();
    }
}
