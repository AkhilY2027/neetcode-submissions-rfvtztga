class Solution {
    public int[][] transpose(int[][] matrix) {
        // Since the matrix is not guarenteed to be square, cannot just do in place
            // Need an entirely new matrix
        int n = matrix.length, m = matrix[0].length;
        int[][] sol = new int[m][n];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                sol[c][r] = matrix[r][c];
        return sol;
    }
}