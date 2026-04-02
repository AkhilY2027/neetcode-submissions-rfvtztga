class Solution {
    private boolean dfs(int i, String s, int leftPar, Boolean[][] dp) {
        if (i >= s.length())
            return leftPar == 0;
        if (leftPar < 0)
            return false;
        if (dp[i][leftPar] != null)
            return dp[i][leftPar];
        
        char c = s.charAt(i);
        boolean sol;
        if (c == '(')
            sol = dfs(i + 1, s, leftPar + 1, dp);
        else if (c == ')')
            sol = dfs(i + 1, s, leftPar - 1, dp);
        else
            sol = dfs(i + 1, s, leftPar + 1, dp) | dfs(i + 1, s, leftPar - 1, dp) | dfs(i + 1, s, leftPar, dp);
        dp[i][leftPar] = sol;
        return sol;
    }
    public boolean checkValidString(String s) {
        // Can do a dfs for the * character – Use dp to limit to O(n^2)
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1];
        return dfs(0, s, 0, dp);
    }
}
