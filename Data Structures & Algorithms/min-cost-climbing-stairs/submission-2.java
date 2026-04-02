class Solution {
    public int recur(int[] cost, int i, int[] dp) {
        if (i >= cost.length) return 0;
        if (dp[i] != Integer.MAX_VALUE) return dp[i];

        dp[i] = cost[i] + Math.min(recur(cost, i + 1, dp), recur(cost, i + 2, dp));

        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        // Use Top-Down DP
        int[] dp = new int[cost.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return Math.min(recur(cost, 0, dp), recur(cost, 1, dp));
    }
}
