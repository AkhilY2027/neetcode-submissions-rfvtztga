class Solution {
    public int backTrack(int[][] matrix, int i, int j, int prev, int[][] dp) {
        if (i < 0 || i >= matrix.length) return 0;
        if (j < 0 || j >= matrix[0].length) return 0;
        if (matrix[i][j] <= prev) return 0;
        if (dp[i][j] != -1) return dp[i][j]; // Don't do repeated work

        // In bounds
        return dp[i][j] = 1 + Math.max(
            backTrack(matrix, i - 1, j, matrix[i][j], dp),
            Math.max(
                backTrack(matrix, i + 1, j, matrix[i][j], dp),
                Math.max(
                    backTrack(matrix, i, j - 1, matrix[i][j], dp),
                    backTrack(matrix, i, j + 1, matrix[i][j], dp)
                )
            )
        );
    }
    public int longestIncreasingPath(int[][] matrix) {
        // Brute Force: Basically a huge dfs?
        int sol = 0;
        // Optimization: Memoization on dp
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = -1; // Initially fill with -1 so we know its emtpy
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sol = Math.max(sol, backTrack(matrix, i, j, -1, dp));
            }
        }
        return sol;

        // Optimization: DFS 
    }
}
