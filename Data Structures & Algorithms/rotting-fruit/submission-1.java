class Solution {
    public int orangesRotting(int[][] grid) {
        // So, max distance away of fresh fruit from rotting fruit
        int n = grid.length, m = grid[0].length;
        // boolean[][] visited = new boolean[n][m];

        // Simulate using a bfs
        Queue<int[]> bfs = new LinkedList<>();
        int fresh = 0;

        // Find number of fresh fruits (to check if we got all of them) and rotten
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) bfs.add(new int[] {i, j});
            }
        }

        // BFS – rot every neighboring fruit
        int time = 0;
        while (!bfs.isEmpty() && fresh > 0) {
            int l = bfs.size();
            for (int k = 0; k < l; k++) {
                int[] cur = bfs.poll();
                int i = cur[0], j = cur[1];

                if (i + 1 >= 0 && j >= 0 && i + 1 < n && j < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    bfs.add(new int[] {i + 1, j});
                    fresh--;
                }
                if (i >= 0 && j + 1 >= 0 && i < n && j + 1 < m && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    bfs.add(new int[] {i, j + 1});
                    fresh--;
                }
                if (i - 1 >= 0 && j >= 0 && i - 1 < n && j < m && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    bfs.add(new int[] {i - 1, j});
                    fresh--;
                }
                if (i >= 0 && j - 1 >= 0 && i < n && j - 1 < m && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    bfs.add(new int[] {i, j - 1});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
