class Solution {
    public int uniquePaths(int m, int n) {
        // It's how many ways you can arrange m downs and n rights
            // (m + n)! / m! * n! ?
                // ACTUALLY: Number of downs is (m - 1) and rights is (n - 1)
                // So: (m + n - 2)! / (m - 1)! * (n - 1)!
            // Essentially a ((m + n) choose m) since we're choosing what moves will be down and which will be right
        
        long sol = 1;
        int div = 1;
        for (int i = Math.max(m, n); i <= m + n - 2; i++) {
            sol *= i;
            sol /= div;
            div++;
        }
        return (int) sol;

        // DP: Notice that number of paths to each point add up
            // Number of paths is number of paths to left point + number of paths to down point
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for (int i = 1; i < m; i++) {
        //     // Each iteration, calculate the new total
        //     for (int j = 1; j < n; j++) {
        //         dp[j] += dp[j - 1];
        //     }
        // }
        // return dp[n - 1];
    }
}
