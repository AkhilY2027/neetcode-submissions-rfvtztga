class Solution {
    public int recur(int[] cost, int i, int[] dp) {
        if (i >= cost.length) return 0;
        if (dp[i] != Integer.MAX_VALUE) return dp[i];

        dp[i] = cost[i] + Math.min(recur(cost, i + 1, dp), recur(cost, i + 2, dp));

        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        // Use Top-Down DP
        // int[] dp = new int[cost.length];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // return Math.min(recur(cost, 0, dp), recur(cost, 1, dp));

        // Or Bottom-Up DP
            // Can space optimize by altering the costs array directly
        int[] dp = new int[cost.length + 1]; // 0 and 1 can be combined into one array
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(
                dp[i - 1] + cost[i - 1],
                dp[i - 2] + cost[i - 2]
            );
        }
        return dp[cost.length];
    }
}
