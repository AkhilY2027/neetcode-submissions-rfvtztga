class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        // So at any point, string can be either 2 or 1 to correspond
            // Cannot be 2 if there is a leading 0/num is greater than 26
            // Cannot be 1 if 0 – have to select from previous
        int n = s.length();
        int[] dp = new int[n + 1];
        // dp[n - 1] = 1;
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            // For 1s
            if (c != '0') dp[i] += dp[i + 1];

            // For 2s
            if (i == n - 1 || c == '0' || c > '2' || ( c == '2' && s.charAt(i + 1) > '6' )) continue;
            dp[i] += dp[i + 2];
        }
        return dp[0];
    }
}
