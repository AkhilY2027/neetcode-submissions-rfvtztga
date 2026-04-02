class Solution {
    public int recur(int[] nums, int curIndex, int curTarget) {
        // if (curTarget < 0) return 0;
        if (curIndex == nums.length) return curTarget == 0 ? 1 : 0;
        return recur(nums, curIndex + 1, curTarget + nums[curIndex])
            + recur(nums, curIndex + 1, curTarget - nums[curIndex]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recur(nums, 0, target);
    }
}
