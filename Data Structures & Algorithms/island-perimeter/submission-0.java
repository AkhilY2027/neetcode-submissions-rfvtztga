class Solution {
    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0)
            return 1;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;
        
        // Otherwise, travel in all four directions to find perimeter
        int sol = 0;
        sol += dfs(i - 1, j, grid, visited);
        sol += dfs(i + 1, j, grid, visited);
        sol += dfs(i, j - 1, grid, visited);
        sol += dfs(i, j + 1, grid, visited);
        return sol;
    }
    public int islandPerimeter(int[][] grid) {
        // Can do like this:
            // Dfs on a land throughout graph, directions on all four sides
            // If we reach water or out of bounds, we know there's an edge there – return 1
            // Add all together
        int sol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sol = dfs(i, j, grid, new boolean[grid.length][grid[0].length]);
                    break;
                }
            }
            if (sol > 0)
                break;
        }
        return sol;
    }
}