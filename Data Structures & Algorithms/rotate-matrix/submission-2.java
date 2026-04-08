class Solution {
    public void rotate(int[][] matrix) {
        // Easy way to do this: First, flip matrix upside down, then transpose matrix

        // 1. Flip matrix upside down
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        // 2. Transpose matrix
            // Basically switch every i,j on one diagonal half with j,i
        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
