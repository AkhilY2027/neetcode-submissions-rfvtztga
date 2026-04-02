class Solution {
    private void recurIslands(char[][] grid, boolean[][] visited, int i, int j) {
        // Out of bounds
        if (i < 0 || i >= visited.length) return;
        if (j < 0 || j >= visited[0].length) return;

        // Visited/Water
        if (grid[i][j] == '0') return;
        if (visited[i][j]) return;

        // Found a one that isn't visited
        visited[i][j] = true;
        // Go to neighboring places too
        recurIslands(grid, visited, i + 1, j);
        recurIslands(grid, visited, i - 1, j);
        recurIslands(grid, visited, i, j + 1);
        recurIslands(grid, visited, i, j - 1);
    }
    public int numIslands(char[][] grid) {
        // If there is a one, there is an island
            // Loop through all of the grid - If we find a one that isn't visited, find all 1s connected to it
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    // Recur on the islands
                    islands++;
                    recurIslands(grid, visited, i, j);
                }
            }
        }
        return islands;
    }
}
