class Solution {
    public boolean canJump(int[] nums) {
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);

        // Basically, go through and keep a track of the indices that we can reach
            // With dp, ensure that we do not calculate repeated indices
        // Queue<Integer> indices = new LinkedList<>();
        // indices.add(0);
        // while(indices.size() > 0) {
        //     int curIndex = indices.remove();
        //     if (dp[curIndex] != -1) {
        //         // Must mean we have already traversed this path somewhere – can reach at some point
        //         // indices.add(dp[curIndex]);
        //         continue;
        //     }

        //     int indexToJump = curIndex + nums[curIndex];
        //     if (indexToJump >= nums.length - 1) return true;
        //     dp[curIndex] = indexToJump;
        //     indices.add(indexToJump);
        // }

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true; // Can reach
        for (int i = nums.length - 2; i >= 0; i--) {
            // For each step, we flash forward the amount of steps to see if any elements are true
            int maxJumps = nums[i];
            dp[i] = false;
            for (int j = Math.min(i + maxJumps, nums.length - 1); j > i; j--) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
