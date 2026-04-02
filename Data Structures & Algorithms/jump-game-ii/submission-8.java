class Solution {
    public int jump(int[] nums) {
        // Bottom-Up DP
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            // At each index, get the minimum amount of jumps needed after this index
            int curJump = nums[i];
            int minJumps = Integer.MAX_VALUE;
            for (int k = i + 1; k <= i + curJump && k < n; k++) {
                if (dp[k] == -1) continue;
                minJumps = Math.min(minJumps, dp[k] + 1);
            }
            dp[i] = minJumps == Integer.MAX_VALUE ? -1 : minJumps;
            System.out.println("Found best jumps for index " + i + " is " + dp[i]);
        }
        return dp[0];
    }
}
