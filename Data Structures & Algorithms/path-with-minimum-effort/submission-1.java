class Solution {

    public int minimumEffortPath(int[][] heights) {
        // Notice that you can go in any direction to minimize the differences, so can't use dfs + dp
            // Instead, want to do a djkstra's algorithm to find the shortest path
                // Since we only want to add "min efforts" within the path until we get to the last cell

        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        pq.add(new int[] {0, 0, 0});

        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], diff = cur[2];

            if (i == n - 1 && j == m - 1)
                return diff;
            if (dist[i][j] < diff) continue; // Don't need to consider any more
                // This is our alternative for a visited array – if we come back to this square with a bigger difference, then we looped unnecessarily

            for (int[] direction : directions) {
                int newi = i + direction[0], newj = j + direction[1];
                if (newi < 0 || newi >= n)
                    continue;
                if (newj < 0 || newj >= m)
                    continue;
                
                // Add possible neighbors we can do for shortest pths
                int newDiff = Math.max(diff, Math.abs(heights[i][j] - heights[newi][newj]));
                if (newDiff < dist[newi][newj]) {
                    dist[newi][newj] = newDiff;
                    pq.add(new int[] {newi, newj, newDiff});
                }
            }
        }
        return -1; // Shouldn't get here anyway
    }
}