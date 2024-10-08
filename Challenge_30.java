import java.util.*;

public class Challenge_30 {

    // Function to find the minimum number of coins required to make the amount
    public static int coinChange(int[] coins, int amount) {
        // Edge case: if amount is 0, no coins are needed
        if (amount == 0) return 0;

        // Create a dp array and initialize it
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill with a value greater than the maximum possible number of coins
        dp[0] = 0; // No coins needed to make 0 amount

        // Iterate over each coin
        for (int coin : coins) {
            // Update the dp array for the current coin
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] hasn't changed, return -1 (amount cannot be formed)
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins1, amount1));  // Output: 3

        // Test Case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Minimum coins needed: " + coinChange(coins2, amount2));  // Output: -1

        // Test Case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Minimum coins needed: " + coinChange(coins3, amount3));  // Output: 0

        // Test Case 4
        int[] coins4 = {1, 3, 4};
        int amount4 = 6;
        System.out.println("Minimum coins needed: " + coinChange(coins4, amount4));  // Output: 2 (3 + 3 or 4 + 1 + 1)
    }
}
