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
        Queue<Pair<Integer, Integer>> bfs = new LinkedList<>();
        bfs.add(new Pair<>(0, 0));
        while(!bfs.isEmpty()) {
            // Continuously add the possible jumps
            int n = bfs.size();
            for (int s = 0; s < n; s++) {
                // For each child
                Pair<Integer, Integer> curPair = bfs.remove();
                int curIndex = curPair.getKey();
                int curJumps = curPair.getValue();

                // Now, jump
                if (nums[curIndex] == 0) continue;
                for (int i = curIndex + 1; i <= curIndex + nums[curIndex] && i < nums.length; i++) {
                    if (i == nums.length - 1) return curJumps + 1; // Since we're doing bfs, first one we get to is the fastest
                    bfs.add(new Pair<>(i, curJumps + 1));
                }
            }
        }
        return 0;
    }
}
