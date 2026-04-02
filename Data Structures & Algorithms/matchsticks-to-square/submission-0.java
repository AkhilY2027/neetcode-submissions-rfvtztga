class Solution {
    private boolean dfs(int[] matchsticks, int[] sums, int i) {
        if (i == matchsticks.length)
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];

        for (int s = 0; s < 4; s++) {
            sums[s] += matchsticks[i];
            if (dfs(matchsticks, sums, i + 1)) return true;
            sums[s] -= matchsticks[i];
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        // Basically, need to put all numbers into a sum / 4 box
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++)
            sum += matchsticks[i];
        if (sum % 4 != 0) return false;

        // Maybe can sort the matchsticks and match greatest to least numbers?
            // Can't since we never know the true way to combine matchsticks
        
        // Brute Force is a decision tree to find where all matchsticks are the same length
        return dfs(matchsticks, new int[4], 0);
    }
}