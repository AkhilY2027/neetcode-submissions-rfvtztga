class Solution {
    public int uniquePaths(int m, int n) {
        // // Basically just a shifting row upward dp-wise
        // if (m < n) {
        //     int temp = m;
        //     m = n;
        //     n = temp;
        // }

        // int[] dp = new int[m];
        // Arrays.fill(dp, 1);

        // for (int i = 0; i < n - 1; i++) {
        //     dp[m - 1] = 1;
        //     for (int j = m - 2; j >= 0; j--) {
        //         dp[j] += dp[j + 1];
        //     }
        // }
        // return dp[0];

        // Math solution:
            // Have m + n - 2 moves in total
            // Only m - 1 moves are to the right
            // Need show all possible combinations of these moves within total
        if (m == 1 || n == 1)
            return 1;
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        // Need to calculate: (m + n - 2 over m - 1) = (m * m + 1 * ... * m + n - 2) / (n - 1)!
        long sol = 1;
        int bottom = 1;
        for (int top = m; top < m + n - 1; top++) {
            sol *= top;
            sol /= bottom;
            bottom++;
        }
        return (int) sol;
    }
}
