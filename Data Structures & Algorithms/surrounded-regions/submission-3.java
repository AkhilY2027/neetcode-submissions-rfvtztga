class Solution {
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length)
            return;
        if (j < 0 || j >= board[0].length)
            return;
        if (board[i][j] == 'X' || board[i][j] == 'K')
            return;
        
        board[i][j] = 'K';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
    }

    public void solve(char[][] board) {
        // If we're modifying in-place, we need a way to distinguish between Os that are surrounded and Os that aren't
        
        // Brute Force: For every O, use dfs on the grid to check if its surrounded (Find an X in all cardinal directions)
            // Time Complexity: (n^2 * 4n^2)?
        
        // Optimization:
            // Intuition: Either we're surrounded by Xs or at least one edge touches the border
            // Thus, any O that touches the border + Os that touch those Os cannot be "surrounded"
            // Algo:
                // Do dfs on any O on the border and "mark" it as something else (idk, "K" maybe)
                // Then, on a second pass, go through all squares and transform all Os into Xs and Ks into Os
        
        // 1. Dfs
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        // 2. Mark board properly
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'K')
                    board[i][j] = 'O';
            }
        }
    }
}
