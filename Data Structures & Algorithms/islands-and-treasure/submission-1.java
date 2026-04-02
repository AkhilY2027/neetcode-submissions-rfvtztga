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
        // int n = grid.length, m = grid[0].length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         onTreasure(grid, i, j, n, m);
        //     }
        // }

        // More optimal to use BFS since we guarentee we're only going once through array
        Queue<int[]> bfs = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) bfs.add(new int[] {i, j});
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            int curI = cur[0];
            int curJ = cur[1];
            for (int[] dir : dirs) {
                int newI = dir[0] + curI;
                int newJ = dir[1] + curJ;
                if (newI < 0 || newI >= n) continue;
                if (newJ < 0 || newJ >= m) continue;
                if (grid[newI][newJ] != Integer.MAX_VALUE) continue;
                grid[newI][newJ] = grid[curI][curJ] + 1;
                bfs.add(new int[] {newI, newJ});
            }
        }
    }
}
