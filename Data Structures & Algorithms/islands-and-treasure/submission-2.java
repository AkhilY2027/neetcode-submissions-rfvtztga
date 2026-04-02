class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // So do a "bfs" where we get each treasure chest's location + time it takes to get there

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i + 1, j, 1});
                    q.add(new int[] {i, j + 1, 1});
                    q.add(new int[] {i - 1, j, 1});
                    q.add(new int[] {i, j - 1, 1});
                }
            }
        }

        // Traverse on each level
        while (!q.isEmpty()) {
            int len = q.size();
            for (int l = 0; l < len; l++) {
                int[] cur = q.remove();
                int i = cur[0];
                int j = cur[1];
                if (i < 0 || i >= n) continue;
                if (j < 0 || j >= m) continue;
                if (grid[i][j] <= cur[2]) continue; // No reason to go further here since there won't be a way faster from this point
                    // Will automatically stop at water cells or treasure chests

                grid[i][j] = cur[2];
                q.add(new int[] {i + 1, j, cur[2] + 1});
                q.add(new int[] {i, j + 1, cur[2] + 1});
                q.add(new int[] {i - 1, j, cur[2] + 1});
                q.add(new int[] {i, j - 1, cur[2] + 1});
            }
        }
    }
}
