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
        // Queue<int[]> bfs = new LinkedList<>();
        // bfs.add(new int[] {0, 0}); // Index to number of jumps made
        // while (!bfs.isEmpty()) {
        //     // Add all new jumps until we found our answer
        //     int n = bfs.size();
        //     for (int i = 0; i < n; i++) {
        //         int[] cur = bfs.poll();
        //         int curIndex = cur[0];
        //         int curJumps = cur[1];
        //         if (nums[curIndex] == 0) continue;

        //         for (int k = curIndex + 1; k <= curIndex + nums[curIndex] && k < nums.length; k++) {
        //             if (k == nums.length - 1) return curJumps + 1;
        //             bfs.add(new int[] {k, curJumps + 1});
        //         }
        //     }
        // }
        // return 0;

        // Greedy BFS Optimization:
            // Want to store the "window"/possibilties of jumps that can be made at each level
                // End once length has reached
            // Still O(n) but O(1) space

        int jumps = 0;
        int l = 0, r = 0;

        while(r < nums.length - 1) { // So long as we haven't reached the end
            // Within each loop of possibilities, want the furthest r we can jump to
                // Next l will always be one ahead of the current r (as going back into our previous index would be a waste of steps)
            int newR = 0;
            for (int i = l; i <= r; i++)
                newR = Math.max(newR, i + nums[i]);
            l = r + 1;
            r = newR;
            jumps++;
        }
        return jumps;
    }
}
