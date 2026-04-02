class Solution {
    private int dfs(int i, int curSum, int[][] dp, int[] stones, int total, int target) {
        if (curSum >= target || i >= stones.length)
            return Math.abs(curSum - (total - curSum));
        if (dp[i][curSum] != -1)
            return dp[i][curSum];
        
        dp[i][curSum] = Math.min(
            dfs(i + 1, curSum, dp, stones, total, target), // Don't add
            dfs(i + 1, curSum + stones[i], dp, stones, total, target) // Add
        );
        return dp[i][curSum];
    }
    
    public int lastStoneWeightII(int[] stones) {
        // Goal is to either destroy all stones or have the smallest y - x at the end
            // No specific math/greedy solution for this as there are many combinations to equalize y and x
            // Instead, do a dfs to look through all possibilities – then optimize via DP
        
        // Can base the equalization of stone weights via the sum of all stone weights divided by 2
            // Intuition: Weight/2 - Weight/2 is the least possible difference
                // In reality, will look like a subarray smashing against another subarray – will always lead to this difference
            // So, need to find a subarray that is the closest to our target
        
        // Thus, DP is: f(i, x) -> i is index we're currently at, x is sum of subarray so far
            // All the while, trying to get as close to sum/2 as possible for x (then "other" subarray is equal as well)

        // Get total Sum
        int total = 0;
        for (int stone : stones)
            total += stone;
        int target = (total + 1) / 2;

        // Then, dfs
        int[][] dp = new int[stones.length][target + 1];
        for (int i = 0; i < stones.length; i++)
            for (int j = 0; j <= target; j++)
                dp[i][j] = -1;
        
        return dfs(0, 0, dp, stones, total, target);
    }
}