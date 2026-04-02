class Solution {
    private int backTrack(int curRow, int n, Set<Integer> cols, Set<Integer> rtlDiag, Set<Integer> ltrDiag) {
        // Base case: At end row
        if (curRow >= n)
            return 1;
        
        // Otherwise, go through all possible columns within current row to see if we can place the queen down here
        int sol = 0;
        for (int curCol = 0; curCol < n; curCol++) {
            if (cols.contains(curCol) ||
                rtlDiag.contains(curRow + curCol) ||
                ltrDiag.contains(curRow - curCol))
                continue;
            
            cols.add(curCol);
            rtlDiag.add(curRow + curCol);
            ltrDiag.add(curRow - curCol);

            sol += backTrack(curRow + 1, n, cols, rtlDiag, ltrDiag);

            cols.remove(curCol);
            rtlDiag.remove(curRow + curCol);
            ltrDiag.remove(curRow - curCol);
        }
        return sol;
    }
    public int totalNQueens(int n) {
        // Basically, each queen is on a unique row and column
            // Intuition method: Place a queen in first row, then in remaining spots of next row, and so on
            // Need to be able to easily check where a queen's position is both on row, col, and diagonals
                // May use hashset?
                // For diagonals, store separately for left and right diagonals – also, store by reducing down to square corresponding on first row
                    // Easier way: Store row - col and row + col for right to left and left to right diagonal respectively (same as the diagonal goes)

        // Final Algo: Go through each row and place a queen in a col wherever possible
            // Store where queens would attack in other cols, other right to left diagonals, and other left to right diagonals – This way, can check if current placement is in their line of sight
            // If we reach the end row, we have found one possible method
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rtlDiag = new HashSet<>();
        Set<Integer> ltrDiag = new HashSet<>();
        return backTrack(0, n, cols, rtlDiag, ltrDiag);
    }
}