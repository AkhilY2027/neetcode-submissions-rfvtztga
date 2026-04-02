class Solution {
    public int recur(String t1, String t2) {
        // Base Case: One or both are null strings
        if (t1.isEmpty() || t2.isEmpty()) {
            return 0;
        }

        // Cases: Strings only have one character:

        // Now check if we have to add 1:
        int add = 0;
        if (t1.charAt(0) == t2.charAt(0)) {
            return 1 + recur(t1.substring(1), t2.substring(1));
        }

        // Otherwise, we know that the current characters do not match, so go through the other possible options:
        return Math.max(recur(t1, t2.substring(1)), recur(t1.substring(1), t2));

        // This is the wrong solution as we repeat the diagonal (Will eventually get to it within the next iteration)
        // return Math.max(recur(t1.substring(1), t2.substring(1)), Math.max(recur(t1, t2.substring(1)), recur(t1.substring(1), t2)));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // My Solution:
        // return recur(text1, text2);

        // DP Solution - Uses an array straight up instead of recursion
            // Less memory this way I think
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // Arrays.fill(dp, 0);

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}
