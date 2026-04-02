class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<>();
        int t = 0, b = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;
        while (l <= r && t <= b) {
            // Add every edge and then shrink
            for (int i = l; i <= r; i++)
                sol.add(matrix[t][i]); // Top edge
            t++;
            for (int i = t; i <= b; i++)
                sol.add(matrix[i][r]); // Right edge
            r--;
            if (t <= b) {
                for (int i = r; i >= l; i--)
                    sol.add(matrix[b][i]); // Bottom edge
                b--;
            }
            if (l <= r) {
                for (int i = b; i >= t; i--)
                    sol.add(matrix[i][l]); // Left edge
                l++;
            }
        }
        return sol;
    }
}
