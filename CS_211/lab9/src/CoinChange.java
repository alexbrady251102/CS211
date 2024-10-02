import java.util.Arrays;
import java.util.Stack;

public class CoinChange
{
    public static int coinChange(int[] coins, int amount)
    {
        // Create an array to store the minimum number of coins needed to make change for each amount
        int[] dp = new int[amount + 1];

        // Create an array to store the last coin used to make change for each amount
        int[] lastCoin = new int[amount + 1];

        // Initialize the arrays with a value greater than the maximum amount, except for dp[0]
        Arrays.fill(dp, amount + 1);
        Arrays.fill(lastCoin, -1);
        dp[0] = 0;

        // Loop through all amounts from 1 to amount
        for (int i = 1; i <= amount; i++)
        {
            // Loop through all coins
            for (int j = 0; j < coins.length; j++)
            {
                // If the current coin can be used to make change for i
                if (coins[j] <= i) {
                    // Update dp[i] to be the minimum of its current value and dp[i - coins[j]] + 1
                    if (dp[i - coins[j]] + 1 < dp[i])
                    {
                        dp[i] = dp[i - coins[j]] + 1;
                        lastCoin[i] = j;
                    }
                }
            }
        }

        // If dp[amount] is still greater than the maximum amount, there is no solution
        if (dp[amount] > amount)
        {
            return -1;
        } else {
            // Create a stack to store the coin denominations used to make change for amount
            Stack<Integer> stack = new Stack<Integer>();
            int i = amount;
            while (i > 0)
            {
                stack.push(coins[lastCoin[i]]);
                i -= coins[lastCoin[i]];
            }


            System.out.print("Minimum number of coins needed to make change for " + amount + " cents: " + dp[amount]);
            System.out.print("\nDenominations used to make change for " + amount + " cents: ");
            while (!stack.isEmpty())
            {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();

            return dp[amount];
        }
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 5, 10, 25};
        int amount = 34;
        int result = CoinChange.coinChange(coins, amount);
    }
}

