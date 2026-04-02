class Solution {
    public int recur(int[] nums, int curNumIndex) {
        if (curNumIndex == nums.length - 1) return 0;
        if (nums[curNumIndex] == 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = curNumIndex + 1; i <= curNumIndex + nums[curNumIndex] && i < nums.length; i++) {
            min = Math.min(min, recur(nums, i));
        }
        return min + 1;
    }

    public int jump(int[] nums) {
        // return recur(nums, 0); // Dfs - O(2^n) I think

        // Do BFS instead
        // Queue<Pair<Integer, Integer>> bfs = new LinkedList<>();
        // bfs.add(new Pair<>(0, 0));
        // while(!bfs.isEmpty()) {
        //     // Continuously add the possible jumps
        //     int n = bfs.size();
        //     for (int s = 0; s < n; s++) {
        //         // For each child
        //         Pair<Integer, Integer> curPair = bfs.remove();
        //         int curIndex = curPair.getKey();
        //         int curJumps = curPair.getValue();

        //         // Now, jump
        //         if (nums[curIndex] == 0) continue;
        //         for (int i = curIndex + 1; i <= curIndex + nums[curIndex] && i < nums.length; i++) {
        //             if (i == nums.length - 1) return curJumps + 1; // Since we're doing bfs, first one we get to is the fastest
        //             bfs.add(new Pair<>(i, curJumps + 1));
        //         }
        //     }
        // }
        // return -1;

        // Greedy Optimized Solution of BFS:
            // Essentially, instead of storing the individual jumps at every level in a tree
            // Store the "window" of jumps that can be made (possibilities) - End once length has reached
            // Same time complexity (O(n)) but O(1) space complexity
        int jumps = 0;
        int l = 0, r = 0;

        while(r < nums.length - 1) {
            // Go through all values within l to r and find the value that jumps the farthest (new right)
                // New left will always be old right + 1 (Always a way to get there)
            int newR = 0;
            for (int i = l; i <= r; i++) {
                newR = Math.max(newR, i + nums[i]);
            }
            l = r + 1;
            r = newR;
            jumps++;
        }
        return jumps;
    }
}
