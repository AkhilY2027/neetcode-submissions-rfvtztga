class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // int[] dp = new int[n + 1];
        // dp[n] = 0;
        // dp[n - 1] = nums[n - 1];
        // for (int i = n - 2; i >= 0; i--)
        //     dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        // return dp[0];
        int dp2 = 0;
        int dp1 = nums[n - 1];
        int dp = Math.max(dp1, nums[n - 2] + dp2);
        for (int i = n - 3; i >= 0; i--) {
            dp2 = dp1;
            dp1 = dp;
            dp = Math.max(dp1, nums[i] + dp2);
        }
        return dp;
    }
}
