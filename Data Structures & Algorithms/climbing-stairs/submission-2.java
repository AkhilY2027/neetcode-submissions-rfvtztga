class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // DP Solution – O(n) time and O(n) space
        // int[] dp = new int[n];
        // dp[n - 1] = 1;
        // dp[n - 2] = 2;
        // for (int i = n - 3; i >= 0; i--) {
        //     dp[i] = dp[i + 1] + dp[i + 2];
        // }
        // return dp[0];

        // More efficient: Use variables to store the three numbers necessary
        int one = 1;
        int two = 2;
        int three = 0;
        for (int i = n - 3; i >= 0; i--) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }
}
