class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Each cell can either reach the pacific/atlantic

        // For pacific, go top to bottom - First row can reach, but rows after that?
        // Want to see if there's any 
        int n = heights.length, m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            pacific[0][j] = true;
        }
        for (int i = 1; i < n; i++) {
            pacific[i][0] = true;
            // Check if above or left can reach
            for (int j = 1; j < m; j++) {
                // if (pacific[i][j] = true) continue;
                if ((pacific[i - 1][j] && (heights[i - 1][j] <= heights[i][j]))
                 || (pacific[i][j - 1] && (heights[i][j - 1] <= heights[i][j])))
                    pacific[i][j] = true;
            }

            // Then, go backwards for right
            for (int j = m - 2; j > 0; j--) {
                if (pacific[i][j + 1] && (heights[i][j + 1] <= heights[i][j]))
                    pacific[i][j] = true;
            }
        }

        // Same for atlantic but in reverse
        boolean[][] atlantic = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            atlantic[n - 1][j] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            atlantic[i][m - 1] = true;
            // Check if above or right can reach
            for (int j = m - 2; j >= 0; j--) {
                if (atlantic[i + 1][j] && (heights[i + 1][j] <= heights[i][j])
                || (atlantic[i][j + 1] && (heights[i][j + 1] <= heights[i][j])))
                    atlantic[i][j] = true;
            }

            // Then, go backwards for left
            for (int j = 1; j < m - 1; j++) {
                if (atlantic[i][j - 1] && (heights[i][j - 1] <= heights[i][j]))
                    atlantic[i][j] = true;
            }
        }

        // Now, check all and if both are true, add to list
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    sol.add(temp);
                }
            }
        }
        return sol;
    }
}
