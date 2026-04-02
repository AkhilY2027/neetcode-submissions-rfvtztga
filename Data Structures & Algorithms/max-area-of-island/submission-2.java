class Solution {
    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length)
            return 0;
        if (j < 0 || j >= grid[0].length)
            return 0;
        if (grid[i][j] == 0 || visited[i][j])
            return 0;

        visited[i][j] = true;
        return 1 + dfs(grid, i + 1, j, visited)
            + dfs(grid, i, j + 1, visited)
            + dfs(grid, i - 1, j, visited)
            + dfs(grid, i, j - 1, visited);
    }
    public int maxAreaOfIsland(int[][] grid) {
        // Is this not just finding all islands and returning the areas?
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
            }
        }
        return maxArea;
    }
}
