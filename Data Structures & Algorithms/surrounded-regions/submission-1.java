class Solution {
    public void solve(char[][] board) {
        // If not surrounded, at least one edge is board itself/O
            // Can move from outward square to inner square
            // Each step, check if the square is connected to another O/board itself?
        // int l = 0, r = board.length;
        // int hb = 0, he = board[0].length;
        // while (l < r) {
        //     // Check the upper boundary on the upper row
        //     for (int i = hb; i < he; i++) {
        //         if (l - 1 < 0 || 1)
        //     }

        //     // Check the lower boundary on the lower row

        //     // Check the left boundary on the lower col

        //     // Check the right boundary on the upper col
        // }

        // Insight: Return everything except for the unsurrounded regions
        int n = board.length, m = board[0].length;

        // Do a dfs: Basically, change every non-O you find into a T that is within bounds
            // Start from ends and work your way inwards via dfs – that way, know what is "surrounded" and what isn't
            // Surrounded follows same logic as before – at least one edge is board itself/O

        // Start on each border cell and dfs
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(board, n, m, i, 0);
            if (board[i][m - 1] == 'O')
                dfs(board, n, m, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                dfs(board, n, m, 0, j);
            if (board[n - 1][j] == 'O')
                dfs(board, n, m, n - 1, j);
        }

        // Then, loop through all of board
            // Ts become Os (unsurrounded) and all other Os (unreached by dfs) become Xs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int n, int m, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') return;
        board[i][j] = 'T';
        dfs(board, n, m, i + 1, j);
        dfs(board, n, m, i, j + 1);
        dfs(board, n, m, i - 1, j);
        dfs(board, n, m, i, j - 1);
    }
}
