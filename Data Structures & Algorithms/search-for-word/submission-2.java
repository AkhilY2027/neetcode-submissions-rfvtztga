class Solution {
    public boolean recur(char[][] board, int i, int j, String word, int charIndex, boolean[][] visited) {
        if (charIndex >= word.length()) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (visited[i][j]) return false;
        if (word.charAt(charIndex) != board[i][j]) return false;
        // Now, go through all words
        visited[i][j] = true;
        if (recur(board, i - 1, j, word, charIndex + 1, visited) ||
            recur(board, i + 1, j, word, charIndex + 1, visited) ||
            recur(board, i, j - 1, word, charIndex + 1, visited) ||
            recur(board, i, j + 1, word, charIndex + 1, visited)
        ) {
            visited[i][j] = false;
            return true;
        }
        visited[i][j] = false;
        return false;
        // boolean result = false;
        // result |= recur(board, i - 1, j, word, charIndex + 1, visited);
        // result |= recur(board, i + 1, j, word, charIndex + 1, visited);
        // result |= recur(board, i, j - 1, word, charIndex + 1, visited);
        // result |= recur(board, i, j + 1, word, charIndex + 1, visited);
        // visited[i][j] = false;
        // return result;
    }
    public boolean exist(char[][] board, String word) {
        // Backtracking solution
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recur(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;

        // Optimizations: BFS + DP - Nope
        // Space Optimization - Directly modify the board to get rid of the char whenever you visit it
            // This way, don't keep track of a visited array (Very minor improvement)
    }
}
