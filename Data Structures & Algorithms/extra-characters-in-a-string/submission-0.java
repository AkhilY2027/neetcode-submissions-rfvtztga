class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {

    private int dfs(int i, String s, Trie trie, int[] dp) {
        if (i >= s.length()) return 0;
        if (dp[i] != -1) return dp[i];

        // Two Cases: Either see if we can form a word starting from this letter or don't
        int sol = 1 + dfs(i + 1, s, trie, dp);

        TrieNode cur = trie.root;
        for (int j = i; j < s.length(); j++) {
            if (!cur.children.containsKey(s.charAt(j)))
                break; // On this case, we don't have any more words to check
            cur = cur.children.get(s.charAt(j));
            if (cur.isWord)
                sol = Math.min(sol, dfs(j + 1, s, trie, dp));
        }

        dp[i] = sol;
        return sol; 
    }

    public int minExtraChar(String s, String[] dictionary) {
        // Intuition: A DP problem because we are going down decision trees
            // Especially in edge case where a substring can break down into different strings within the dictionary
            // If we do an O(n) travel for each index to find substrings to match within dictionary, this will take O(n^3) time
                // O(n) for dfs itself, O(n) for looping through rest of string for each index, then O(n) for getting that substring and matching it against a dictionary word
                // Also need O(m * k) to convert dictionary to a hashset for easy comparison
                // Thus, total time is O(n^3 + m * k)
            // Can reconfigure to O(m * k) check every index to see whether there is a word in the dictionary that can match the next substring
                // Thus, this solution is (n * m * k)

        // Optimization: Use a trie to easily see if a substring is a word within the dictionary
            // Will first take O(n) dfs with an O(n) looping through rest of string
                // However, upon this looping, can compare in O(1) time through trie to see if any substring is a word/prefix of a word within the dictionary
            // Thus, O(n^2 + m * k) (O(m * k) for creating the trie itself)
        Trie trie = new Trie();
        for (String word : dictionary)
            trie.addWord(word);

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        return dfs(0, s, trie, dp);
    }
}