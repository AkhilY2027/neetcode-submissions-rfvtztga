class Solution {
    public int backTrack(String s, String t, int i, int j, int[][] dp) {
        if (j >= t.length()) return 1; // Matched all of t
        else if (i >= s.length()) return 0; // If we got here, means we didn't match all of t before s
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;
        if (s.charAt(i) == t.charAt(j)) // If match, we move up the t substring by 1
            dp[i][j] += backTrack(s, t, i + 1, j + 1, dp);
        dp[i][j] += backTrack(s, t, i + 1, j, dp); // Otherwise, take case of where we move up only s

        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        // This is a dp problem I swear
            // Number of ways to get to s.length() and t.length()
            // Subsequence => f(i, j) = How many ways there are from s.substring(i) to t.substring(j)
        
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1; // Set all to -1 to say "I don't know"
        return backTrack(s, t, 0, 0, dp);
    }
}
