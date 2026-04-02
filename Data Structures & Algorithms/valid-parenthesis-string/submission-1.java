class Solution {
    Boolean[][] dp;
    private boolean Find(String s, int i, int l) {
        if (i == s.length()) {
            if (l == 0) return true;
            else return false;
        }
        if (l < 0) return false;

        if (dp[i][l] != null) return dp[i][l];

        char c = s.charAt(i);
        boolean sol = false;
        if (c == '(') sol = Find(s, i + 1, l + 1);
        else if (c == ')') sol = Find(s, i + 1, l - 1);
        else sol = Find(s, i + 1, l) || Find(s, i + 1, l - 1) || Find(s, i + 1, l + 1); // Either left, right, or nothing

        dp[i][l] = sol;
        return sol;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n + 1][n + 1]; // Optimize using Dp
        return Find(s, 0, 0);
    }
}
