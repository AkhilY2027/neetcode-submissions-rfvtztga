class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n + 1]; // Each subproblem is best amount if we haven't robbed the previous house
        dp[n] = 0;
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        int best1 = dp[1];
        dp[n - 1] = 0;
        dp[n - 2] = nums[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return Math.max(dp[0], best1);
    }
}
