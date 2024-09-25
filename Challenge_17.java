import java.util.*;

public class Challenge_17 { 
    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();
        
        // Step 1: Divide n by 2 until it's odd
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        // Step 2: Check odd numbers from 3 onwards
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        // Step 3: If n is still greater than 2, it must be prime
        if (n > 2) {
            factors.add(n);
        }
        
        return factors;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = s.nextInt();
        System.out.println("Prime factors: " + primeFactorization(n));
        s.close();
    }
}
