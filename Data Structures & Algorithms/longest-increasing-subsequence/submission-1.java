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
        return dp(nums, nums.length - 1, Integer.MAX_VALUE);
    }
}
