class Solution {
    public int jump(int[] nums) {
        // Bottom-Up DP – O(n^2)
        // int n = nums.length;
        // int[] dp = new int[n];
        // dp[n - 1] = 0;
        // for (int i = n - 2; i >= 0; i--) {
        //     // At each index, get the minimum amount of jumps needed after this index
        //     int curJump = nums[i];
        //     int minJumps = Integer.MAX_VALUE;
        //     for (int k = i + 1; k <= i + curJump && k < n; k++) {
        //         if (dp[k] == -1) continue;
        //         minJumps = Math.min(minJumps, dp[k] + 1);
        //     }
        //     dp[i] = minJumps == Integer.MAX_VALUE ? -1 : minJumps;
        //     System.out.println("Found best jumps for index " + i + " is " + dp[i]);
        // }
        // return dp[0];

        // Do a BFS for O(n)
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[] {0, 0}); // Index to number of jumps made
        while (!bfs.isEmpty()) {
            // Add all new jumps until we found our answer
            int[] cur = bfs.poll();
            int curIndex = cur[0];
            int curJumps = cur[1];
            if (nums[curIndex] == 0) continue;

            for (int k = curIndex + 1; k <= curIndex + nums[curIndex] && k < nums.length; k++) {
                if (k == nums.length - 1) return curJumps + 1;
                bfs.add(new int[] {k, curJumps + 1});
            }
        }
        return 0;

        // Greedy BFS Optimization:
            // Want to store the "window"/possibilties of jumps that can be made at each level
                // End once length has reached
            // Still O(n) but O(1) space
    }
}
