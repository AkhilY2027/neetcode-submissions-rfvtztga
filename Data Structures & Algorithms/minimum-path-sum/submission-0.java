class Solution {
    private int dfs(int i, int j, int[][] grid, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = grid[i][j] + Math.min(
            dfs(i + 1, j, grid, dp),
            dfs(i, j + 1, grid, dp)
        );
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        // So just 2d dp?
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;
        dp[n - 1][m - 1] = grid[n - 1][m - 1];
        return dfs(0, 0, grid, dp);
    }
}