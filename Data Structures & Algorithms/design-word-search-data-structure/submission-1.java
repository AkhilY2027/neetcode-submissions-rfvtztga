class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isWord;

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

    private boolean searchHelper(TrieNode cur, String word, int i) {
        if (i >= word.length()) return cur.isWord;

        // At this point, c

        char c = word.charAt(i);
        if (c == '.') {
            // If '.', then check all at once
            for (char key : cur.children.keySet()) {
                if (searchHelper(cur.children.get(key), word, i + 1)) return true;
            }
        }
        else {
            // Check if char i exists as a child of cur
            if (cur.children.containsKey(c)) return searchHelper(cur.children.get(c), word, i + 1);
        }
        return false;
    }

    public boolean search(String word) {
        // TrieNode search = root;
        // for (char c : word.toCharArray()) {
        //     if (!search.children.containsKey(c)) return false;
        //     search = search.children.get(c);
        // }
        // return search.isWord;
        return searchHelper(root, word, 0);
    }
}
