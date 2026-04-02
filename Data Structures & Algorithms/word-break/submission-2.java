class Solution {
    public boolean backTrack(String s, int i, List<String> wordDict, Boolean[] cache) {
        if (i >= s.length()) return true;
        if (cache[i] != null && cache[i] == false) return false;

        // Go through all words and see if they match the current string
        for (String prefix : wordDict) {
            if (s.substring(i).startsWith(prefix))
                if (backTrack(s, i + prefix.length(), wordDict, cache)) return true;
        }

        cache[i] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // Optimize by caching results
        Boolean[] cache = new Boolean[s.length()];
        return backTrack(s, 0, wordDict, cache);
    }
}
