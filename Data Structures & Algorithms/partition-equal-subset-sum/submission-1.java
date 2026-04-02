class Solution {
    private boolean recur(int[] nums, int i, int sumLeft, Boolean[][] dp) {
        if (sumLeft < 0) return false;
        if (i >= nums.length) return sumLeft == 0;
        if (dp[i][sumLeft] != null) return dp[i][sumLeft];

        dp[i][sumLeft] = recur(nums, i + 1, sumLeft - nums[i], dp)
            || recur(nums, i + 1, sumLeft, dp);
        return dp[i][sumLeft];
    }

    public boolean canPartition(int[] nums) {
        // Basically, want a way to get total sum / 2 –> Ensures there is a partition
        int sumToReach = 0;
        for (int i = 0; i < nums.length; i++)
            sumToReach += nums[i];
        if (sumToReach % 2 == 1) return false;
        sumToReach /= 2;

        // Brute Force: Using backtracking to get every single combination

        // Intuitions:
            // Sum of each subset is total sum / 2
            // If we subtract each element of the subset against each other, result is 0
        
        // Optimization: Using dp?
            // Subproblem: f(x, n) -> Is there a way to arrange nums from index x onward to reach target sum of n
            // At x, we either include x and try to reach n - x, or we don't and continue
                // Want a point where n = 0 –> If negative, go back and say false
        Boolean[][] dp = new Boolean[nums.length][sumToReach + 1];
        return recur(nums, 0, sumToReach, dp);
    }
}
