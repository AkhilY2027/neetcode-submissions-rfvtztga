class Solution {
    private int dfs(int i, int[] stoneValue, int aliceTurn, int[][] dp) {
        if (i >= stoneValue.length)
            return 0;
        if (dp[i][aliceTurn] != -1)
            return dp[i][aliceTurn];

        // If this is Alice's Turn, we want to maximize Alice's score
            // If this is Bob's Turn, we want to minimize Alice's future score
        int sol = (aliceTurn == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE; // Need to set to these for the case of not choosing any stones
        int curStoneValue = 0;
        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            curStoneValue += stoneValue[j];
            if (aliceTurn == 0)
                sol = Math.max(sol, curStoneValue + dfs(j + 1, stoneValue, 1, dp));
            else
                sol = Math.min(sol, dfs(j + 1, stoneValue, 0, dp));
        }
        
        dp[i][aliceTurn] = sol;
        return sol;
    }

    private int actualDFS(int i, int[] stoneValue, int[] dp) {
        if (i >= stoneValue.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        // Play the next three moves – does not matter who is currently playing right now
            // Only that current player wants to maximize the score from the current turn
        int sol = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++)
            sol++;
        
        return 0;
    }

    public String stoneGameIII(int[] stoneValue) {
        // Is this dp?
            // Can find Alice's best value then see how to compares to total
        int[][] dp = new int[stoneValue.length][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int bestAliceScore = dfs(0, stoneValue, 0, dp);

        // Now, compare to total and output based on that
        int sum = 0;
        for (int stone : stoneValue)
            sum += stone;
        if (bestAliceScore * 2 > sum)
            return "Alice";
        else if (bestAliceScore * 2 == sum)
            return "Tie";
        else
            return "Bob";

        // Why previous solution was wrong: We were not optimizing for Bob's best score, just minimizing Alice's on Bob's turn (not the same thing)
            // When Bob plays optimally, he should also be able to make Alice score more if he scores more
                // But with the previous dp equation, Bob does not care what he scores, only that Alice scores lesser
            // We need to record both Alice and Bob's score to really show the optimal plays
                // So dp should instead record the difference between Alice and Bob's score
            // Since we are only recording totals, we only need one row of dp instead
        // int[] dp = new int[stoneValue.length];
        // Arrays.fill(dp, -1);
    }
}