class Solution {
    private void backTrack(int r, int n, HashSet<Integer> columnsVisited, HashSet<Integer> negDiagonalsVisited, HashSet<Integer> posDiagonalsVisited, char[][] board, List<List<String>> sol) {
        // r keeps track of iterations/row we're on – if we ever reach n, have found a valid way
        if (r == n) {
            List<String> toCopy = new ArrayList<>();
            for (char[] row : board) {
                toCopy.add(new String(row));
            }
            sol.add(toCopy);
            return;
        }

        // Iterate through each column
        for (int c = 0; c < n; c++) {
            if (columnsVisited.contains(c) || negDiagonalsVisited.contains(r - c) || posDiagonalsVisited.contains(r + c))
                continue;
            
            // Add the queen and iterate forward
            columnsVisited.add(c);
            negDiagonalsVisited.add(r - c);
            posDiagonalsVisited.add(r + c);
            board[r][c] = 'Q';

            backTrack(r + 1, n, columnsVisited, negDiagonalsVisited, posDiagonalsVisited, board, sol);

            // Reverse changes
            columnsVisited.remove(c);
            negDiagonalsVisited.remove(r - c);
            posDiagonalsVisited.remove(r + c);
            board[r][c] = '.';
        }
    }
    public List<List<String>> solveNQueens(int n) {
        // P Sure this is backtracking, just not sure how
        // 1 - 1
        // 2 - 0 (Can attack diagonally)
        // 3 - 0
        // 4 - 2

        // Algo: Each queen has to be in a separate row and column
            // To check diagonals, keep track of (r - c) to know what diagonal is being used at what point
                // Negative diagonals: r - c
                // Positive diagonals: r + c
        HashSet<Integer> columnsVisited = new HashSet<>();
        HashSet<Integer> negDiagonalsVisited = new HashSet<>();
        HashSet<Integer> posDiagonalsVisited = new HashSet<>();
        List<List<String>> sol = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backTrack(0, n, columnsVisited, negDiagonalsVisited, posDiagonalsVisited, board, sol);

        return sol;
    }
}
