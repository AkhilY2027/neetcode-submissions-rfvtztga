class Solution {
    public int minDistance(String word1, String word2) {
        // Dynamic Programming
        // Subproblem - dp[i][j] is min cost to transform word1 substring from i to word2 substring from j
        // Bellman: dp[i][j] = 1 + min{dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1]}

        // Full array solution
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // Fill known costs first
        dp[n][m] = 0;
        for (int j = m - 1; j >= 0; j--) { // At this point, one word matches, so other needs to add words to make up for it
            dp[n][j] = m - j;
        }
        for (int i = 0; i < n; i++) {
            dp[i][m] = n - i;
        }

        // Then, fill in each col at a time
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i + 1][j + 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        return dp[0][0];
    }
}
