class Solution {
    Boolean[][] dp;

    private boolean Find(String s, int i, int l) {
        if (i == s.length()) {
            if (l == 0) return true;
            else return false;
        }
        if (l < 0) return false;

        if (dp[i][l] != null) return dp[i][l];

        char c = s.charAt(i);
        boolean sol = false;
        if (c == '(') sol = Find(s, i + 1, l + 1);
        else if (c == ')') sol = Find(s, i + 1, l - 1);
        else sol = Find(s, i + 1, l) || Find(s, i + 1, l - 1) || Find(s, i + 1, l + 1); // Either left, right, or nothing

        dp[i][l] = sol;
        return sol;
    }

    public boolean checkValidString(String s) {
        // int n = s.length();
        // dp = new Boolean[n + 1][n + 1]; // Optimize using Dp – Now, O(n^2)
        //     // With bottom up, can space optimize for O(n)
        // return Find(s, 0, 0);

        // Even more efficient: Greedy
            // Count amount of open and close as necessary
            // On every wildcard, we update "possibilites" of how many open we can have
        int leftMin = 0, leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            }
            else if (c == ')') {
                leftMin = Math.max(leftMin - 1, 0); // Never left min reach 0 because at minimum, will just make wild cards 0
                leftMax -= 1; // However, this can become negative – If at worst is negative, no chance we can make pair all parenthesis
            }
            else {
                leftMax++;
                leftMin = Math.max(leftMin - 1, 0);
            }

            if (leftMax < 0) return false;
        }
        return leftMin == 0;
    }
}
