class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    private boolean searchDFS(String word, int i, TrieNode cur) {
        if (i == word.length()) return cur.isWord;

        // Go to next node
        char c = word.charAt(i);
        if (c == '.') {
            // Cycle through all possible words
            boolean sol = false;
            for (char pos : cur.children.keySet()) {
                sol |= searchDFS(word, i + 1, cur.children.get(pos));
            }
            return sol;
        }
        else if (!cur.children.containsKey(c)) return false;
        else return searchDFS(word, i + 1, cur.children.get(c));
    }

    public boolean search(String word) {
        return searchDFS(word, 0, root);
    }
}
