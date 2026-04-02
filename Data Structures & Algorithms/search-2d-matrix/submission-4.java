class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // So binary search on the row and then the col?
        int n = matrix.length, m = matrix[0].length;

        // Row binary search – Find the row it's in
        int l = 0, r = n - 1;
        while (l <= r) {
            // int mid = (l + r) / 2;
            // System.out.println("Checking mid: " + mid);
            // // if (mid == l) break;
            // if (matrix[mid][0] == target) return true;
            // else if (target < matrix[mid][0]) r = mid - 1;
            // else l = mid + 1;
            int mid = (l + r) / 2;
            if (target < matrix[mid][0]) r = mid - 1;
            else if (target > matrix[mid][m - 1]) l = mid + 1;
            else break; // Found the row that works
        }

        if (l > r) return false; // Since we only check for absolutes, did not find the row here

        // Col binary search
        int row = (l + r) / 2; // Recreate mid
        l = 0;
        r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) return true;
            else if (target < matrix[row][mid]) r = mid - 1;
            else l = mid + 1;
        }
        return matrix[row][l] == target;
    }
}
