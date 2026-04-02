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
        // Boolean[] cache = new Boolean[s.length()];
        // return backTrack(s, 0, wordDict, cache);

        // Can also work our way backwards for more efficient solution
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true; 
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if ((i + word.length()) <= s.length() && s.substring(i, i + word.length()).equals(word))
                    dp[i] = dp[i + word.length()];
                if (dp[i]) // Unnecessary to check further if its true
                    break;
            }
        }
        return dp[0];
    }
}
