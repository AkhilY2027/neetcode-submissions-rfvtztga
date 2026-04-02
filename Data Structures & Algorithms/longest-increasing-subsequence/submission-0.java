class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // Go through all of list and find best sequence
        int sol = 0;
        for (int i = 0; i < nums.length; i++) {
            sol = Math.max(sol, dp[i]);
        }
        return sol;
    }
}
