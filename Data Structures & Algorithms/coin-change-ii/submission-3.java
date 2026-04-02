class Solution {
    public int backTrack(int index, int[] coins, int target) {
        // Basically, just for loop through it
        if (target == 0) {
            // Add numCoins to res
            // res.add(numCoins.clone());
            return 1;
        }
        if (target < 0) { // Overshot
            return 0;
        }

        int sum = 0;
        for (int i = index; i < coins.length; i++) {
            sum += backTrack(i, coins, target - coins[i]);
        }
        return sum;
    }
    public int change(int amount, int[] coins) {
        // Backtracking again?
            // Problem with this solution: Will double count solutions
            // New approach: Count number of distinct combos
        // return backTrack(0, coins, amount);

        // DP: O(m * n) with same space complexity
        // int[][] dp = new int[coins.length][amount + 1];

        // // All 0s have only 1 way to solve them
        // for (int i = 0; i < dp.length; i++) {
        //     dp[i][0] = 1;
        // }

        // // Calculate first row manually
        // for (int j = 1; j < dp[0].length; j++) {
        //     if (j >= coins[0]) dp[0][j] += dp[0][j - coins[0]];
        // }

        // // Now, calculate row by row
        // for (int i = 1; i < dp.length; i++) {
        //     for (int j = 1; j < dp[0].length; j++) {
        //         // This is the column, and i is the row pointer
        //         // Each column gets its value from the value on the same row - coin value + value below it
        //         if (j >= coins[i]) dp[i][j] += dp[i][j - coins[i]];
        //         dp[i][j] += dp[i - 1][j];
        //     }
        // }

        // return dp[dp.length - 1][dp[0].length - 1];

        // DP: Space Complexity is now only O(n) by only keeping two rows in memory
        int[][] dp = new int[2][amount + 1];

        // Calculate the first row manually again - Same as normal
        dp[0][0] = 1;
        for (int j = 0; j < dp[0].length; j++) {
            if (j >= coins[0]) dp[0][j] += dp[0][j - coins[0]];
        }

        // Now, continuously calculate the second row for as long as needed
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // Two conditions:
                    // If element to left (- coin value), then add
                    // If element below, add
                dp[1][j] = dp[0][j];
                if (j >= coins[i]) dp[1][j] += dp[1][j - coins[i]];
                // Now, since we found the value, bottom value is useless - replace
                dp[0][j] = dp[1][j];
            }
        }

        return dp[0][dp[0].length - 1];
    }
}
