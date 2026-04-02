class Solution {
    public int uniquePaths(int m, int n) {
        // Basically just a shifting row upward
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n - 1; i++) {
            dp[m - 1] = 1;
            for (int j = m - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
}
