class Solution {
    public int dp(String s, int i, int k, int streak, char lastChar, int[][] dp) {
        if (i == s.length()) return streak;
        if (k < 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        // If we match, go onto next char with streak intact, otherwise don't
        char c = s.charAt(i);
        if (c == lastChar) {
            dp[i][k] = dp(s, i + 1, k, streak + 1, c, dp);
        }
        else {
            // Either change or ignore
            dp[i][k] = lastChar == '0' ? dp(s, i + 1, k, 1, c, dp) : Math.max(
                dp(s, i + 1, k, 1, c, dp),
                dp(s, i + 1, k - 1, streak + 1, c, dp)
            );
        }
        return dp[i][k];
    }

    public int characterReplacement(String s, int k) {
        // int n = s.length();
        // int[][] dp = new int[n + 1][k + 1];
        // for (int[] r : dp) Arrays.fill(r, -1);
        // dp(s, 0, k, 0, '0', dp);
        // return dp[n - 1][k - 1];

        // More optimal to use Sliding Window
            // For each window, take window length - frequency of biggest character to see if we can replace the rest - valid substring
                // Keep track of most freqent variable using hashmap + maxf variable to immediately say number
                // This ensures our algo is not O(26 * n) - by searching through entire hashmap - but O(n)
                // However, on decrement, technically will have to look at all characters to see which is more frequent
                    // But since we're trying to maximize maxf, it doesn't matter if it becomes lesser – only find solution when greater
            // Add and remove based on this
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxf = 0, sol = 0;
        while (r < s.length()) {
        // for (int r = 0; r < s.length(); r++) {
            // Add right
            char c = s.charAt(r);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, charMap.get(c));

            // Decrement string if not valid
            while ((r - l + 1) - maxf > k) { // Again, not updating maxf here because we're trying to maximize maxf at all times anyway
                char lc = s.charAt(l);
                charMap.put(lc, charMap.get(lc) - 1);
                l++;
            }

            // Otherwise, check if this is the best solution
            sol = Math.max(sol, r - l + 1);
            r++;
        }
        return sol;
    }
}
