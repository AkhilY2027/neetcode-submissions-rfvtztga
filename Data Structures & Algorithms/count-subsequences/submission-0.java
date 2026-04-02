class Solution {
    public int backTrack(String s, String t, int i, int j, int[][] dp) {
        // Base Cases
        if (j >= t.length()) return 1; // Got here properly
        else if (i >= s.length()) return 0; // Did not find subsequence
        
        if (dp[i][j] != -1) return dp[i][j];

        // Now, have to calculate
        dp[i][j] = 0;
        if (s.charAt(i) == t.charAt(j)) dp[i][j] += backTrack(s, t, i + 1, j + 1, dp); // Either we match or we don't
        dp[i][j] += backTrack(s, t, i + 1, j, dp);
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        // F(si, ti) -> If there is a substring formed from these indices
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1; // To stand for fact we don't have an answer for this subsequence
            }
        }
        return backTrack(s, t, 0, 0, dp);
    }
}
