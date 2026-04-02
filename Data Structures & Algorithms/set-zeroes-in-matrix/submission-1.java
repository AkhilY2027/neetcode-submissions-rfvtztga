class Solution {
    public void setZeroes(int[][] matrix) {
        // Pitfall to look out for: A 1 must only be converted to a 0 due to another original 0 (not another 1 to 0)
        // Easy 1: Store the rows and cols where 0s are found and reset the matrix based on those
        // Easy 2: FOr O(1) space, search through array for each row and col

        // Maybe set the 1s to something else and then on a second pass, set them to 0?
            // Still O(n^3) solution
            // Cannot do this as matrix can be any element

        // Idea: Go through rows only and find 0s there – set 1s to -1s

        // Intuition: Go back to original idea of storing which rows and cols are zeroed out
            // However, store these inside the input matrix, as it won't matter if the matrix is eventually changed
            // Will be one bit of overlap at (0,0), so have a single bit to store that value
        
        int n = matrix.length, m = matrix[0].length;
        boolean firstRowZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Zero out column
                    matrix[0][j] = 0;

                    // Zero out row
                    if (i > 0) matrix[i][0] = 0;
                    else firstRowZero = true;
                }
            }
        }

        // Then, zero out based on those values
            // First, zero out everything but first row and col, as they still contain info we need – Can't destroy yet
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Then, first col
        if (matrix[0][0] == 0)
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        
        // Finally, first row
        if (firstRowZero)
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
    }
}
