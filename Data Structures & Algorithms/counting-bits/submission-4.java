class Solution {
    public int[] countBits(int n) {
        // O(nlogn) Solution
            // This is because most of the time, we're doing repeated work
        // int[] sol = new int[n + 1];
        // for (int i = 0; i <= n; i++) {
        //     // Count 1s for each
        //     int cur = i;
        //     while (cur != 0) {
        //         cur &= (cur - 1);
        //         sol[i]++;
        //     }
        // }
        // return sol;

        // O(n) Solution
            // Intuition: Each number is the number / 2 + if the number is even or odd
            // Thus, we can split into subproblems –> dp
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = dp[i >> 1] + (i % 2);
        return dp;
    }
}
