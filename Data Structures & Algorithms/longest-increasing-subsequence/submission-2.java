class Solution {
    private int dp(int[] nums, int i, int curMax) {
        if (i < 0) return 0;

        int sol = dp(nums, i - 1, curMax);
        if (nums[i] < curMax) sol = Math.max(sol, dp(nums, i - 1, nums[i]) + 1);
        return sol;
    }
    public int lengthOfLIS(int[] nums) {
        // DP Problem – Basically, at each level, have an index and a max limit
            // Go backwards based on whether you can fit the max limit or not?
            // Subproblem -> f(i, max) = Math.max(f(i - 1, max), 1 + f(i - 1, nums[i]) if nums[i] < max)
                // Base Case: i == -1, so return 0
        
        // Top-down
        // return dp(nums, nums.length - 1, Integer.MAX_VALUE);

        // Bottom-Up
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = 1;
            // Go through next indices and find all places we can start a subsequence at
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // Now, since we have best subsequences at each index, find best index
        int sol = 0;
        for (int i = 0; i < nums.length; i++)
            sol = Math.max(sol, dp[i]);
        return sol;
    }
}
