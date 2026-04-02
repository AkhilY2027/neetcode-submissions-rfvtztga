class Solution {
    private void traverse(int[][] grid, int i, int j, int n, int m, int curDistance) {
        if (i < 0 || i >= n) return;
        if (j < 0 || j >= m) return;
        if (grid[i][j] == 0 || grid[i][j] == -1) return;
        if (curDistance > grid[i][j]) return;

        grid[i][j] = curDistance;
        
        // Move in all directions
        traverse(grid, i + 1, j, n, m, curDistance + 1);
        traverse(grid, i, j + 1, n, m, curDistance + 1);
        traverse(grid, i - 1, j, n, m, curDistance + 1);
        traverse(grid, i, j - 1, n, m, curDistance + 1);
    }
    
    private void onTreasure(int[][] grid, int i, int j, int n, int m) {
        if (grid[i][j] == 0) {
            traverse(grid, i + 1, j, n, m, 1);
            traverse(grid, i, j + 1, n, m, 1);
            traverse(grid, i - 1, j, n, m, 1);
            traverse(grid, i, j - 1, n, m, 1);
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                onTreasure(grid, i, j, n, m);
            }
        }
    }
}
