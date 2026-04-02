class Solution {
    private boolean dfs(int i, String s, int leftPar, Boolean[][] dp) {
        if (i >= s.length())
            return leftPar == 0;
        if (leftPar < 0)
            return false;
        if (dp[i][leftPar] != null)
            return dp[i][leftPar];
        
        char c = s.charAt(i);
        boolean sol;
        if (c == '(')
            sol = dfs(i + 1, s, leftPar + 1, dp);
        else if (c == ')')
            sol = dfs(i + 1, s, leftPar - 1, dp);
        else
            sol = dfs(i + 1, s, leftPar + 1, dp) | dfs(i + 1, s, leftPar - 1, dp) | dfs(i + 1, s, leftPar, dp);
        dp[i][leftPar] = sol;
        return sol;
    }
    public boolean checkValidString(String s) {
        // // Can do a dfs for the * character – Use dp to limit to O(n^2)
        // int n = s.length();
        // Boolean[][] dp = new Boolean[n + 1][n + 1];
        // return dfs(0, s, 0, dp);

        // O(n) Method: Stack
            // Intuition: Notice that * only needs to apply in two scenarios
                // 1. For an unmatched ) that doesn't have a ( to go with it
                // 2. For unmatched (s at the end
            // Thus, use stack to eliminate matching parenthesis and keep track of asterisks
                // Need to use stacks instead of counts as the order of both must be kept track of
                // In other words, we are pushing the indices into the stack instead of just the characters
        Stack<Integer> leftPar = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                leftPar.add(i);
            else if (c == ')'){
                if (!leftPar.isEmpty())
                    leftPar.pop();
                else if (!asterisk.isEmpty())
                    asterisk.pop();
                else
                    return false;
            }
            else
                asterisk.add(i);
        }
        // At end, match unmatched (s with asterisks
        while (!leftPar.isEmpty() && !asterisk.isEmpty())
            if (leftPar.pop() > asterisk.pop())
                return false;
        return leftPar.isEmpty();
    }
}
