class Solution {
    public int numSquares(int n) {
        // There is always one to fall back on

        // Preliminary thoughts: Find greatest square for that number, subtract, repeat?
            // Of course, there is the problem of finding the best square at all times
            // Counter example: 12
                // With greedy algo: 3 + 1 + 1 + 1
                // Without: 2 + 2 + 2
        
        // Instead, need to do dp in the vein of "Coin Change" problem
            // So just solve min squares for n = 0, n = 1, etc.
                // To find the squares each n can take, need to calculate the max square each n can "hold" in sqrt(n) time
            // Time: O(n * sqrt(n))
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); // Each n has a maximum number of moves of n (1 + 1 + ...)
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
            // For each n, find the square and subtract – O(sqrt(n)) time
            for (int s = 1; s * s <= i; s++)
                dp[i] = Math.min(dp[i], 1 + dp[i - (s * s)]);
        return dp[n];
    }
}