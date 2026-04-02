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
        int curStoneTotal = 0;
        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            curStoneTotal += stoneValue[j];
            sol = Math.max(sol, curStoneTotal - actualDFS(j + 1, stoneValue, dp)); // Next turn is the other player's turn, so want to maximize score against theirs
        }
        dp[i] = sol;
        
        return sol;
    }

    public String stoneGameIII(int[] stoneValue) {
        // Easy Method based on Stone Game 2: Get Alice's best score and compare to total
        // int[][] dp = new int[stoneValue.length][2];
        // for (int[] row : dp)
        //     Arrays.fill(row, -1);
        // int bestAliceScore = dfs(0, stoneValue, 0, dp);

        // // Now, compare to total and output based on that
        // int sum = 0;
        // for (int stone : stoneValue)
        //     sum += stone;
        // if (bestAliceScore * 2 > sum)
        //     return "Alice";
        // else if (bestAliceScore * 2 == sum)
        //     return "Tie";
        // else
        //     return "Bob";

        // Optimization for Space: Instead of finding Alice's best score, find the best Alice's score - Bob's score
            // In other words, on every step of the dfs, just find the best score for the current player, regardless of who the player is
            // This way, we only need one row of dp instead
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
        int sol = actualDFS(0, stoneValue, dp);

        if (sol == 0)
            return "Tie";
        else if (sol > 0)
            return "Alice";
        else
            return "Bob";
    }
}