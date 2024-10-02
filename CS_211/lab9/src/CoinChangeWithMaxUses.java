import java.util.Arrays;
import java.util.Stack;

public class CoinChangeWithMaxUses {
    public static int coinChange(int[] denominations, int[] maxUses, int amount) {
        // Create an array to store the minimum number of coins needed to make change for each amount
        int[] dp = new int[amount + 1];

        // Create an array to store the last coin used to make change for each amount
        int[] lastCoin = new int[amount + 1];

        // Initialize the arrays with a value greater than the maximum amount, except for dp[0]
        Arrays.fill(dp, amount + 1);
        Arrays.fill(lastCoin, -1);
        dp[0] = 0;

        // Loop through all amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Loop through all coins
            for (int j = 0; j < denominations.length; j++) {
                // If the current coin can be used to make change for i and it has not reached its maximum number of uses
                if (denominations[j] <= i && maxUses[j] > 0) {
                    // Update dp[i] to be the minimum of its current value and dp[i - denominations[j]] + 1
                    if (dp[i - denominations[j]] + 1 < dp[i]) {
                        dp[i] = dp[i - denominations[j]] + 1;
                        lastCoin[i] = j;
                    }
                }
            }
            // Decrement the maximum number of uses for each coin used to make change for i
            while (lastCoin[i] != -1) {
                maxUses[lastCoin[i]]--;
                i -= denominations[lastCoin[i]];
            }
        }

        // If dp[amount] is still greater than the maximum amount, there is no solution
        if (dp[amount] > amount) {
            return -1;
        } else {
            // Create a stack to store the coin denominations used to make change for amount
            Stack<Integer> stack = new Stack<Integer>();
            int i = amount;
            while (i > 0) {
                stack.push(denominations[lastCoin[i]]);
                i -= denominations[lastCoin[i]];
            }

            // Print the minimum number of coins and the coin denominations used
            System.out.print("Minimum number of coins needed to make change for " + amount + " cents: " + dp[amount]);
            System.out.print("\nDenominations used to make change for " + amount + " cents: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();

            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5};
        int[] maxUses = {2, 3, 1};
        int amount = 11;
        int result = CoinChangeWithMaxUses.coinChange(denominations, maxUses, amount);
    }
}
