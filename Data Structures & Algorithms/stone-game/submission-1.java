class Solution {
    private int dfs(int[] piles, int[][] dp, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        // Need to account for both Alice and Bob decisions
            // Thus, if we have an "odd" subarray, then we know Bob is making the decision – Only look at subpossibilities
        int leftVal = (r - l) % 2 == 0 ? piles[l] : 0;
        int rightVal = (r - l) % 2 == 0 ? piles[r] : 0;
        dp[l][r] = Math.max(
            dfs(piles, dp, l + 1, r) + leftVal,
            dfs(piles, dp, l, r - 1) + rightVal
        );
        return dp[l][r];
    }
    public boolean stoneGame(int[] piles) {
        // Play optimally: Weigh up what opponent is going to get vs. what you're going to get
            // If you take left over right, then opponent can take left + 1 or right
                // Want to ensure left has least difference between those two over right
        
        // int l = 0, r = piles.length - 1;
        // int a = 0, b = 0;
        // boolean aTurn = true;
        // while (l <= r) {
        //     int toGive = 0;
        //     if (r == l) {
        //         toGive = piles[l];
        //         l++;
        //     }
        //     else if (r - l == 2) {
        //         if (piles[r] > piles[l]) {
        //             toGive = piles[r];
        //             r--;
        //         }
        //         else {
        //             toGive = piles[l];
        //             l++;
        //         }
        //     }
        //     else {
        //         // More than two, can consider all possibilities
        //         int lDiff = piles[l] - Math.max(piles[r], piles[l + 1]);
        //         int rDiff = piles[r] - Math.max(piles[l], piles[r - 1]);

        //         if (rDiff > lDiff)  { // r is better
        //             toGive = piles[r];
        //             r--;
        //         }
        //         else {
        //             toGive = piles[l];
        //             l++;
        //         }
        //     }

        //     // Based on turn and toGive, add
        //     if (aTurn) a += toGive;
        //     else b += toGive;
        //     aTurn = !aTurn;
        // }
        // return a > b;

        // O(1) Solution – Alice always wins
        // return true;

        // Follow-up: What if there are no restrictions on length of array
            // Do a DP Problem – f(l, r) -> Max Alice total from that subarray
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        int aSum =  dfs(piles, dp, 0, n - 1);

        // Now, check if Alice's sum is better than total of array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += piles[i];
        return aSum > (sum / 2);
    }
}