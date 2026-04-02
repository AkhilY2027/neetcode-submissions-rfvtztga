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
        System.out.println(Arrays.toString(coins));

        int[] reverseCoins = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            reverseCoins[i] = coins[coins.length - i - 1];
        }
        System.out.println(Arrays.toString(reverseCoins));

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
        int sol = backTrack(reverseCoins, amount, 0);
        return sol == Integer.MAX_VALUE ? -1 : sol - 1;
    }
}
