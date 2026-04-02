class Solution {
    public int numDecodings(String s) {
        // So either read one or two characters at a time
            // If we ever get to a zero, then there's no more potential to read characters
        
        // Bottom-Up DP
            // There is an optimization to only use three numbers, I know it
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue; // Can't form any possibilities with this – remains 0
            dp[i] = dp[i + 1];
            if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }
}
