class Solution {
    public boolean checkRow(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < board[0].length; i++) {
            if (set.contains(board[row][i])) return false;
            if (board[row][i] != '.') set.add(board[row][i]);
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (set.contains(board[i][col])) return false;
            if (board[i][col] != '.') set.add(board[i][col]);
        }
        return true;
    }

    public boolean checkSquare(char[][] board, int rowStart, int colStart) {
        HashSet<Character> set = new HashSet<>();
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (set.contains(board[i][j])) return false;
                if (board[i][j] != '.') set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // Check Rows
        for (int i = 0; i < board.length; i++) {
            if (!checkRow(board, i)) return false;
        }
        // Check Columns
        for (int i = 0; i < board[0].length; i++) {
            if (!checkColumn(board, i)) return false;
        }
        // Check individual squares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSquare(board, i * 3, j * 3)) return false;
            }
        }
        return true;
    }
}
