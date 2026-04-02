class Solution {
    public int swimInWater(int[][] grid) {
        // // Essentially just minheight along path
        // int n = grid.length, m = grid[0].length;
        // int[][] dp = new int[n][m];
        // dp[n - 1][m - 1] = grid[n - 1][m - 1];
        // for (int j = m - 2; j >= 0; j--) {
        //     dp[n - 1][j] = Math.max(grid[n - 1][j], dp[n - 1][j + 1]);
        // }
        // for (int i = n - 2; i >= 0; i--) {
        //     dp[i][m - 1] = Math.max(grid[i][m - 1], dp[i + 1][m - 1]);
        // }
        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = m - 2; j >= 0; j--) {
        //         dp[i][j] = Math.max(grid[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
        //     }
        // }
        // return dp[0][0];

        // To greedily add best edges, use Djikstra's
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        pq.add(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        // int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int minHeight = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return minHeight; // Because this is a priorityqueue, first time we get here is the best solution

            if (r + 1 >= 0 && c >= 0 && r + 1 < n && c < n && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                pq.add(new int[] {Math.max(minHeight, grid[r + 1][c]), r + 1, c});
            }
            if (r >= 0 && c + 1 >= 0 && r < n && c + 1 < n && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                pq.add(new int[] {Math.max(minHeight, grid[r][c + 1]), r, c + 1});
            }
            if (r - 1 >= 0 && c >= 0 && r - 1 < n && c < n && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                pq.add(new int[] {Math.max(minHeight, grid[r - 1][c]), r - 1, c});
            }
            if (r >= 0 && c - 1 >= 0 && r < n && c - 1 < n && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                pq.add(new int[] {Math.max(minHeight, grid[r][c - 1]), r, c - 1});
            }
        }
        return n * n;
    }
}
