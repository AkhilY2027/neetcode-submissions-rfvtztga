class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] pathsPer = new int[n][m];
        // Bottom row needs to be filled with ones or zeros
        pathsPer[n - 1][m - 1] = obstacleGrid[n - 1][m - 1] == 1 ? 0 : 1;
        for (int j = m - 2; j >= 0; j--)
            pathsPer[n - 1][j] = obstacleGrid[n - 1][j] == 1 ? 0 : pathsPer[n - 1][j + 1];
        
        // Then fill in the rest of the paths
        for (int i = n - 2; i >= 0; i--) {
            pathsPer[i][m - 1] =  obstacleGrid[i][m - 1] == 1 ? 0 : pathsPer[i + 1][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                // Add both space to the left and space down
                pathsPer[i][j] = obstacleGrid[i][j] == 1 ? 0 : (pathsPer[i + 1][j] + pathsPer[i][j + 1]);
            }
        }

        // Debug: Print out grid
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(pathsPer[i]));

        return pathsPer[0][0];
    }
}