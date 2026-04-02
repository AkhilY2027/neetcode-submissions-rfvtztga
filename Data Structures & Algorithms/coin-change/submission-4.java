class Solution {
    public int backTrack(int[] coins, int curAmount, int curIndex) {
        // Basically, just try everything
        if (curAmount == 0) return 1;
        if (curAmount < 0) return Integer.MAX_VALUE;

        int minAmount = Integer.MAX_VALUE;
        for (int i = curIndex; i < coins.length; i++) {
            minAmount = Math.min(minAmount, backTrack(coins, curAmount - coins[i], i));
        }
        return minAmount == Integer.MAX_VALUE ? Integer.MAX_VALUE : minAmount + 1;
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); // Sort by greatest coin first
        // System.out.println(Arrays.toString(coins));

        int[] reverseCoins = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            reverseCoins[i] = coins[coins.length - i - 1];
        }
        // System.out.println(Arrays.toString(reverseCoins));

        // Basically, go throuhg each coin and continually subtract until amount is 0
        // int num = 0;
        // int curCoinIndex = 0;
        // while(amount > 0 && curCoinIndex < reverseCoins.length) {
        //     // First, check if the amount is greater than the coin that we're on
        //     if (amount >= reverseCoins[curCoinIndex]) {
        //         num++;
        //         amount -= reverseCoins[curCoinIndex];
        //     }
        //     else {
        //         // Try to move the index one forward and see if that works
        //         curCoinIndex++;
        //     }
        // }
        // return amount == 0 ? num : -1;

        // PROBLEM: What if subtracting the largest element does not lead to optimal solution?
        // SOL: Backtracking
        // int sol = backTrack(reverseCoins, amount, 0);
        // return sol == Integer.MAX_VALUE ? -1 : sol - 1;

        // Problem with that: Too long
            // Basically trying every sol in a dfs (Want simplest solution)
            
        // Another solution: DP (Bottum-Up)
            // Continuously try to find the best number of coins at each amount level until the amount we need
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Simpler solution than calculating min by always using MAX VALUE
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            // On each level, calculate the minimum
            for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
                if (i >= coins[coinIndex]) {
                    // min = Math.min(min, 1 + dp[i - coins[coinIndex]]);
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[coinIndex]]);
                }
            }
            // dp[i] = min == Integer.MAX_VALUE ? 0 : min;
        }
        // If at max, then we haven't found an actual solution
        return dp[amount] > amount ? -1 : dp[amount];

        // Also: BFS:
        
        // if (amount == 0) return 0;

        // Queue<Integer> q = new LinkedList<>();
        // q.add(0); // Starting amount
        // boolean[] trackNumCoins = new boolean[amount + 1]; // Since the max amount of coins will always be amount
        // trackNumCoins[0] = true;
    }
}
