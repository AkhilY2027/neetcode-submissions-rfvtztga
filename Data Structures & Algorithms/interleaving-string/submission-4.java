class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // int s1Pointer = 0, s2Pointer = 0;
        // int n = 0, m = 0;
        // int lastSubstring = 0;
        // for (char c : s3.toCharArray()) {
        //     if (s1Pointer < s1.length() && c == s1.charAt(s1Pointer)) {
        //         s1Pointer++;
        //         if (lastSubstring != 1) {
        //             if (lastSubstring == 2) m++;
        //             lastSubstring = 1;
        //         }
        //     }
        //     else if (s2Pointer < s2.length() && c == s2.charAt(s2Pointer)) {
        //         s2Pointer++;
        //         if (lastSubstring != 2) {
        //             if (lastSubstring == 1) n++;
        //             lastSubstring = 2;
        //         }
        //     }
        //     else {
        //         return false;
        //     }
        // }
        // return Math.abs(n - m) <= 1;
        // // return true;

        if (s3.length() != s1.length() + s2.length()) return false;

        // DP: Top-Down
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // return dfs(s1, s2, s3, 0, 0, 0, dp);

        // Bottom-Up Iterative solution:
        dp[s1.length()][s2.length()] = true; // Automatically we get here
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
                    dp[i][j] |= dp[i + 1][j];
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
                    dp[i][j] |= dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

    public boolean dfs(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index, Boolean[][] dp) {
        if (s3Index == s3.length()) {
            return (s1Index == s1.length()) && (s2Index == s2.length());
        }
        if (dp[s1Index][s2Index] != null) {
            return dp[s1Index][s2Index];
        }

        boolean sol = false;
        if (s1Index < s1.length() && s3.charAt(s3Index) == s1.charAt(s1Index)) {
            sol = dfs(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, dp);
        }
        if (!sol && s2Index < s2.length() && s3.charAt(s3Index) == s2.charAt(s2Index)) {
            sol = dfs(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, dp);
        }
        dp[s1Index][s2Index] = sol;
        return sol;
    }
}
