class Solution {
    private boolean dfs(char[][] board, int i, int j, HashSet<String> visited, String word, int curChar) {
        String curPosition = i + ", " + j;
        if (visited.contains(curPosition)) return false;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;

        if (board[i][j] != word.charAt(curChar))
            return false;

        // Can continue
        if (curChar == word.length() - 1)
            return true;
        
        visited.add(curPosition);
        boolean check = false;
        check |= dfs(board, i + 1, j, visited, word, curChar + 1);
        check |= dfs(board, i, j + 1, visited, word, curChar + 1);
        check |= dfs(board, i - 1, j, visited, word, curChar + 1);
        check |= dfs(board, i, j - 1, visited, word, curChar + 1);
        visited.remove(curPosition);

        return check;
    }

    public boolean exist(char[][] board, String word) {
        // Do a dfs on the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, new HashSet<>(), word, 0))
                    return true;
            }
        }
        return false;
    }
}
