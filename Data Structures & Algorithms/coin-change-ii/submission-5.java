class Solution {
    public int change(int amount, int[] coins) {
        // Easy Solution: DP on amount
            // Subproblem: f(x, y) -> Number of ways to go from x amount with only y to n demoninations of coins
                // Basically, how many ways are there with this combination + this combination + etc.
                // Want to go from highest demonination of coin to lowest
        // Arrays.sort(coins);
        // int[][] dp = new int[amount + 1][coins.length + 1];
        // for (int i = 0; i < coins.length; i++)
        //     dp[0][i] = 1; // If we reach 0, there is a way forward
        
        // for (int i = coins.length - 1; i >= 0; i--) { // High to low
        //     for (int curAmount = 0; curAmount <= amount; curAmount++) {
        //         if (curAmount >= coins[i]) {
        //             dp[curAmount][i] = dp[curAmount][i + 1]; // Inherit the amount the predecessor can reach as well
        //             dp[curAmount][i] += dp[curAmount - coins[i]][i];
        //         }
        //     }
        // }
        // return dp[amount][0];

        // Iterative dp solution
        Arrays.sort(coins);
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(amount, 0, coins, dp);
    }

    private int dfs(int curAmount, int coinCounter, int[] coins, int[][] dp) {
        if (curAmount == 0)
            return 1;
        if (coinCounter >= coins.length)
            return 0;
        if (dp[curAmount][coinCounter] != -1)
            return dp[curAmount][coinCounter];
        
        int sol = 0;
        if (curAmount >= coins[coinCounter]) {
            // Two options:
            sol += dfs(curAmount, coinCounter + 1, coins, dp); // Go to lesser combination of coins
            sol += dfs(curAmount - coins[coinCounter], coinCounter, coins, dp); // Use current coins and move
        }
        dp[curAmount][coinCounter] = sol;
        return sol;
    }
}
