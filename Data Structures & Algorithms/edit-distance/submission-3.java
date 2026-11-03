class Solution {
    public int minDistance(String word1, String word2) {
        // DP
            // Subproblem: f(i, j) -> Min operations to turn word1.substring(i) to word2.substring(j)
                // If char i == char j, then f(i, j) = f(i + 1, j + 1)
                // Otherwise, f(i, j) = 1 + min{f(i, j + 1), f(i + 1, j) + f(i + 1, j + 1)}
        
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill in known costs
        dp[n][m] = 0; // Ended both
        for (int i = 0; i < m; i++) dp[n][i] = m - i; // One word is filled, need to add to get other word
        for (int i = 0; i < n; i++) dp[i][m] = n - i;

        // Do columns
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i + 1][j + 1];
                else dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
            }
        }
        return dp[0][0];

    }
}
