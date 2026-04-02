class Solution {
    private int dfs(int aliceTurn, int i, int M, int[] piles, int[][][] dp) {
        if (i == piles.length) return 0;
        if (dp[aliceTurn][i][M] != -1) return dp[aliceTurn][i][M];

        // Go through all possible Xs to select
        int sol = aliceTurn == 1 ? 0 : Integer.MAX_VALUE;
        int curTotal = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > piles.length) break;
            curTotal += piles[i + X - 1];
            
            // Simulate on each turn
                // When its alice's turn, want to maximise – which is why we start at 0
                // When its Bob's turn, want to minimize
            if (aliceTurn == 1) sol = Math.max(sol, curTotal + dfs(0, i + X, Math.max(X, M), piles, dp));
            else sol = Math.min(sol, dfs(1, i + X, Math.max(X, M), piles, dp));
                // We use min for all possible Alice turns after Bob because Bob is doing the most efficient move right here
                    // So Bob will make it so Alice can get the least score after his move
                    // But we are only returning Alice's score so not adding total to this
        }

        dp[aliceTurn][i][M] = sol;
        return sol;
    }

    public int stoneGameII(int[] piles) {
        // Three variables: Whose turn it is, what index we are at, what M we have
            // Can do a dfs to calculate all possibilities + a dp to bound it all

        // Use dp to bound exponential algorithm to n^3
        int n = piles.length;
        int[][][] dp = new int[2][n][n + 1];
        for (int [][] layer : dp)
            for (int[] row: layer)
                Arrays.fill(row, -1);
                
        return dfs(1, 0, 1, piles, dp);
    }
}