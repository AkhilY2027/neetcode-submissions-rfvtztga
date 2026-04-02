class Solution {
    public int backTrack(int[][] matrix, int i, int j, int prev) {
        if (i < 0 || i >= matrix.length) return 0;
        if (j < 0 || j >= matrix[0].length) return 0;
        if (matrix[i][j] <= prev) return 0;

        // In bounds
        return 1 + Math.max(
            backTrack(matrix, i - 1, j, matrix[i][j]),
            Math.max(
                backTrack(matrix, i + 1, j, matrix[i][j]),
                Math.max(
                    backTrack(matrix, i, j - 1, matrix[i][j]),
                    backTrack(matrix, i, j + 1, matrix[i][j])
                )
            )
        );
    }
    public int longestIncreasingPath(int[][] matrix) {
        // Brute Force: Basically a huge backtracking sol?
        int sol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sol = Math.max(sol, backTrack(matrix, i, j, -1));
            }
        }
        return sol;
    }
}
