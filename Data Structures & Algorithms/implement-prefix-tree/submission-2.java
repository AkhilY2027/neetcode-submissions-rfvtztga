class TrieNode {
    public HashMap<Character, TrieNode> map;
    public boolean isWord;

    public TrieNode() {
        map = new HashMap<>();
        isWord = false;
    }

    public TrieNode addChar(char c) {
        if (!map.containsKey(c))
            map.put(c, new TrieNode());
        return map.get(c);
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.addChar(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.map.containsKey(c)) return false;
            cur = cur.map.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.map.containsKey(c)) return false;
            cur = cur.map.get(c);
        }
        return true;
    }
}
