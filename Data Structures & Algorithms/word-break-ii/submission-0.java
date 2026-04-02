class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {
    private List<String> dfs(int i, String s, Trie dict, HashMap<Integer, List<String>> dp) {
        System.out.println(i);
        if (i == s.length())
            return Collections.singletonList(""); // Immutable, one-element list
        if (dp.containsKey(i))
            return dp.get(i);

        // Go through trie and see if we can match to a word in the dict
            // At each index, we are constructing the words we can make at that element – then, putting that into dp
        TrieNode cur = dict.root;
        List<String> sol = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (cur.children.containsKey(c))
                cur = cur.children.get(c);
            else
                break;

            if (cur.isWord) {
                // Dfs will return a list of elements/suffixes that can be made with our own
                for (String suffix : dfs(j + 1, s, dict, dp)) {
                    if (suffix.isEmpty()) // We reach the end of the list with this jump, so current i is the last word
                        sol.add(s.substring(i, j + 1));
                    else
                        sol.add(s.substring(i, j + 1) + " " + suffix);
                }
            }
        }

        dp.put(i, sol);
        return sol;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Use a trie to pattern match?
        Trie dict = new Trie();
        for (String word : wordDict)
            dict.addWord(word);

        // Then, use a dp to ensure that we don't do repeated work
        HashMap<Integer, List<String>> dp = new HashMap<>();
        return dfs(0, s, dict, dp);
    }
}