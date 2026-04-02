class Solution {
    private int dfs(int num, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(num))
            return dp.get(num);
        
        // Either: Want to break up factor and return max break up, or return factor itself
        int sol = num;
        for (int i = 1; i < num; i++) {
            int pos = dfs(i, dp) * dfs(num - i, dp);
            sol = Math.max(sol, pos);
        }

        dp.put(num, sol);
        return sol;
    }
    public int integerBreak(int n) {
        // When you "break" up an integer, you are then breaking up the factors further
            // Or not breaking up the factor itself
            // Thus, use DP
        
        // Will be O(n^2) solution as you have to linearly go through and find all possible factors for each level
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);

        // Cannot return factor itself like in dp so handle here
        int sol = 0;
        for (int i = 1; i < n; i++) {
            int pos = dfs(i, dp) * dfs(n - i, dp);
            sol = Math.max(sol, pos);
        }
        return sol;
    }
}