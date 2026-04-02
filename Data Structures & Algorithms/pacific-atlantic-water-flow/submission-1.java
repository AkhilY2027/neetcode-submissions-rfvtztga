class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Intuition: Know that from some cells, can flow into P or A or both
            // So find cells that flow into P, then A
        int n = heights.length, m = heights[0].length;

        boolean[][] pFlow = new boolean[n][m];
        for (int j = 0; j < m; j++) pFlow[0][j] = true; // All of left edge
        for (int i = 1; i < n; i++) {
            pFlow[i][0] = true;

            // Water can only flow up or left to reach the P, so in this column, check all squares up or left
            for (int j = 1; j < m; j++) {
                if ((pFlow[i - 1][j] && (heights[i - 1][j] <= heights[i][j])) || // Checking square to left and see if water can flow to there
                    (pFlow[i][j - 1] && (heights[i][j - 1] <= heights[i][j]))) // Checking square upwards
                        pFlow[i][j] = true;
            }

            // However, there is a chance we can go down to reach the pacific as well
                // Basically a curve that loops back on itself – so need to check that way too
                // Still cannot go right to reach the P, as it will be found in another way
            for (int j = m - 2; j > 0; j--)
                if (pFlow[i][j + 1] && (heights[i][j + 1] <= heights[i][j]))
                    pFlow[i][j] = true;
        }

        // Same thing for A but in reverse
        boolean[][] aFlow = new boolean[n][m];
        for (int j = 0; j < m; j++) aFlow[n - 1][j] = true; // All of right edge
        for (int i = n - 2; i >= 0; i--) {
            aFlow[i][m - 1] = true;

            // In this direction, water flows down and right
            for (int j = m - 2; j >= 0; j--) {
                if ((aFlow[i + 1][j] && (heights[i + 1][j] <= heights[i][j])) ||
                    (aFlow[i][j + 1] && (heights[i][j + 1] <= heights[i][j])))
                        aFlow[i][j] = true;
            }

            // Again, check for loop around
            for (int j = 1; j < m - 1; j++)
                if (aFlow[i][j - 1] && (heights[i][j - 1] <= heights[i][j]))
                    aFlow[i][j] = true;
        }

        // Now, check and see if both are true
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(pFlow[i][j] && aFlow[i][j]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    sol.add(point);
                }
            }
        }
        return sol;
    }
}
