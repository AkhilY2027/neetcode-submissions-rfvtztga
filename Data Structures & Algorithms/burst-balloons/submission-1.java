class Solution {
    public int recur(int[] nums, int[][] dp, int n, int l, int r) {
        if (r < 0 || l >= n || l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        // Pick an index to multiply last
        for (int i = l; i <= r; i++) {
            int num = nums[i];
            int left = l - 1 < 0 ? 1 : nums[l - 1];
            int right = r + 1 >= n ? 1 : nums[r + 1];
            dp[l][r] = Math.max(dp[l][r], num * left * right + recur(nums, dp, n, l, i - 1) + recur(nums, dp, n, i + 1, r));
        }
        return dp[l][r];
    }

    public int maxCoins(int[] nums) {
        // 2D DP
            // Essentially, for each position, thinking what will happen if we pop an index last
            // So the two subarrays next to it will be completely independent (since current index can't be popped)
            // Thus, each subproblem is the bounds of the array we are trying to calculate the max of
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;
        
        // // To make it easier on ourselves, add a 1 to beginning and end of array
        // int[] newNums = new int[n + 2];
        // for (int i = 0; i < n; i++)
        //     newNums[i + 1] = nums[i];
        // newNums[0] = newNums[n + 1] = 1;

        // return recur(newNums, dp, n, 1, newNums.length - 2);
        return recur(nums, dp, n, 0, n - 1);
    }
}
