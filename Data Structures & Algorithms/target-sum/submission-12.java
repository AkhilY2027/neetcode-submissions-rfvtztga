class Solution {
    private int dfs(int i, int[] nums, int curTotal, int target, int[][] dp, int totalSum) {
        if (i == nums.length)
            return curTotal == target ? 1 : 0;
        if (dp[i][curTotal + totalSum] != Integer.MIN_VALUE)
            return dp[i][curTotal + totalSum];
        dp[i][curTotal + totalSum] = dfs(i + 1, nums, curTotal - nums[i], target, dp, totalSum) + dfs(i + 1, nums, curTotal + nums[i], target, dp, totalSum);
        return dp[i][curTotal + totalSum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        // I think this has to be backtracking
            // DP on "i" and "total"
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        int[][] dp = new int[nums.length][2 * totalSum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return dfs(0, nums, 0, target, dp, totalSum);
    }
}
