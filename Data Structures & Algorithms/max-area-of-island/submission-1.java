class Solution {
    public int traverse(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length) return 0;
        if (j < 0 || j >= grid[0].length) return 0;
        if (visited[i][j]) return 0;
        if (grid[i][j] == 0) return 0;

        visited[i][j] = true;
        int sol = 1;
        sol += traverse(grid, i - 1, j, visited);
        sol += traverse(grid, i + 1, j, visited);
        sol += traverse(grid, i, j - 1, visited);
        sol += traverse(grid, i, j + 1, visited);
        return sol;
    }
    public int maxAreaOfIsland(int[][] grid) {
        // Find islands + Return max area
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, traverse(grid, i, j, visited));
            }
        }
        return maxArea;
    }
}
