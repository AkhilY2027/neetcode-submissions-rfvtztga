class Solution {
    public boolean recur(String s, int i, List<String> wordDict, Boolean[] dp) {
        // We're looking forward from s.charAt(i)
            // Want to see if any words in dictionary match at that point
        if (dp[i] != null) return dp[i];

        // System.out.println("At index " + i);

        dp[i] = false; // Can claim at this stage since we're going to come back to this index before exiting
        for (String word : wordDict) {
            if (s.length() - i >= word.length() &&
                s.substring(i).startsWith(word))
                dp[i] |= recur(s, i + word.length(), wordDict, dp);
        } 
        return dp[i];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // Just need to break up string into multiple
            // Dp problem as we can have dictionaries that overlap with words
        Boolean[] dp = new Boolean[s.length() + 1];
        dp[s.length()] = true;

        return recur(s, 0, wordDict, dp);
    }
}
