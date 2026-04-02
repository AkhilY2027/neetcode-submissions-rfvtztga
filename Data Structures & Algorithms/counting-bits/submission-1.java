class Solution {
    public int[] countBits(int n) {
        // Could do a dp problem where every "section" of a power of two is dependent on the corresponding section of 2n-1
        /*
        0 --> 0 --> 0
        1 --> 1 --> 1 (2^0)
        2 --> 10 --> 1
        3 --> 11 --> 2
        4 --> 100 --> 1
        5 --> 101 --> 2
        6 --> 110 --> 2
        5 --> 111 --> 2
        */
        if (n == 0) return new int[] {0};
        if (n == 1) return new int[] {0, 1};
        int[] dp = new int[n + 1];
        for (int powerOfTwo = 1; powerOfTwo <= n; powerOfTwo *= 2) {
            for (int i = powerOfTwo; i < Math.min(powerOfTwo * 2, n + 1); i++) {
                dp[i] = 1 + dp[i - powerOfTwo];
            }
        }
        return dp;
    }
}
