class NumMatrix {

    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        // Is this not just a prefix sum?
        int n = matrix.length, m = matrix[0].length;
        // sumMatrix = new int[n][m];
        // for (int c = 0; c < matrix[0].length; c++)
        //     sumMatrix[0][c] += matrix[0][c];
        // for (int r = 1; r < matrix.length; r++) {
        //     sumMatrix[r][0] = matrix[r][0] + sumMatrix[r - 1][0];
        //     for (int c = 1; c < matrix[0].length; c++)
        //         sumMatrix[r][c] = matrix[r][c] + sumMatrix[r - 1][c];
        // }

        // Difficulty is in setting up the board
            // For easier computations, let the first row and columns be blank – calculate from ever 
        sumMatrix = new int[n + 1][m + 1];
        for (int r = 0; r < n; r++) {
            int continuousSum = 0;
            for (int c = 0; c < m; c++) {
                continuousSum += matrix[r][c];
                sumMatrix[r + 1][c + 1] = continuousSum + sumMatrix[r][c + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */