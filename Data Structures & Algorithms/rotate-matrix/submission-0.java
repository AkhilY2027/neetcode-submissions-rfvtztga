class Solution {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length - 1; // Left and right boundaries
        while (l < r) {
            for (int i = 0; i < r - l; i++) { // To cover the distances between
                int top = l, bottom = r; // Because shape is square

                // To save on memory, save topLeft in temp variable, and then replace in reverse
                int topLeft = matrix[top][l + i];
                matrix[top][l + i] = matrix[bottom - i][l]; // Bottom left into top left
                matrix[bottom - i][l] = matrix[bottom][r - i]; // Bottom right into bottom left
                matrix[bottom][r - i] = matrix[top + i][r]; // Top right into bottom right
                matrix[top + i][r] = topLeft; // Top left into top right
            }
            r--;
            l++;
        }


        // This way is harder because of the nature of 1 number squares – just stick with l and r pointers to make calculations easier
        // for (int x = 0; x < (int) Math.ceil((double) matrix.length / 2); x++) {
        //     for (int y = x; y < matrix[0].length - 1 - x; y++) {
        //         //
        //     }
        // }
    }
}
