public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() { // For creation of root
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {
    public void backTrack(char[][] board, int i, int j, HashSet<String> found, boolean[][] visited, TrieNode trie, String wordForming) {
        // DFS on this node - only if it can be created with a trie
        if (i < 0 || i >= board.length) return;
        if (j < 0 || j >= board[0].length) return;
        if (visited[i][j]) return;
        if (!trie.children.containsKey(board[i][j])) return; // Cannot continue trie

        visited[i][j] = true;
        trie = trie.children.get(board[i][j]);
        wordForming += board[i][j];
        if (trie.isWord)
            found.add(wordForming);

        // BackTrack
        backTrack(board, i + 1, j, found, visited, trie, wordForming);
        backTrack(board, i - 1, j, found, visited, trie, wordForming);
        backTrack(board, i, j + 1, found, visited, trie, wordForming);
        backTrack(board, i, j - 1, found, visited, trie, wordForming);

        visited[i][j] = false;
    }
     
    public List<String> findWords(char[][] board, String[] words) {
        // First, create a trie for all the words
        TrieNode trie = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i]);
        }

        // Then, backtrack
        HashSet<String> found = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backTrack(board, i, j, found, visited, trie, "");
            }
        }

        return new ArrayList<>(found);
    }
}
