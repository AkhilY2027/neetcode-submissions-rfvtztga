class Solution {
    public void setZeroes(int[][] matrix) {
        // Very brute force - O(n^3)
            // Go through orig matrix and mark every zero row and column you find as a 0
            // However, will be doing repeated work + Potentially n work for all n^2 squares
        
        // Another solution - Simply mark what rows and columns need to be zeroed on first pass
            // Then, on second pass, replace values if in those rows and columns
        // int rows = matrix.length, cols = matrix[0].length;
        // boolean[] zeroRow = new boolean[rows];
        // boolean[] zeroCol = new boolean[cols];

        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         if (matrix[i][j] == 0) {
        //             zeroRow[i] = true;
        //             zeroCol[j] = true;
        //         }
        //     }
        // }

        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         if (zeroRow[i] || zeroCol[j]) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        
        // Final solution - Space Optimized
            // Place these arrays of rows and columns to be zeroed out within input matrix
            // However, will overlap at [0][0] - use an extra bit of memory to keep track here

        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRowZero = false;

        // Collect info on what to zero out
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // Zero out the column
                    // Now, zero out the row
                    if (i > 0)
                        matrix[i][0] = 0;
                    else
                        firstRowZero = true;
                }
            }
        }

        // Now, zero out everything but the first row + col
            // Cannot include first col yet as it contains info for what rows to zero out
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first col
        if (matrix[0][0] == 0)
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;

        // Zero out the first row
        if (firstRowZero)
            for (int i = 0; i < cols; i++)
                matrix[0][i] = 0;
    }
}
