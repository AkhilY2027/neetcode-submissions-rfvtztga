class Solution {
    private int[][] dpArr;
    private int totalSum;
    public int recur(int[] nums, int curIndex, int curTarget, int target) {
        if (curIndex == nums.length) return curTarget == target ? 1 : 0;
        if (dpArr[curIndex][curTarget + totalSum] != Integer.MIN_VALUE) return dpArr[curIndex][curTarget + totalSum];
        dpArr[curIndex][curTarget + totalSum] =
            recur(nums, curIndex + 1, curTarget + nums[curIndex], target)
            + recur(nums, curIndex + 1, curTarget - nums[curIndex], target);
        return dpArr[curIndex][curTarget + totalSum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        dpArr = new int[nums.length][totalSum * 2 + 1];
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < 2 * totalSum + 1; j++)
                dpArr[i][j] = Integer.MIN_VALUE;
        return recur(nums, 0, 0, target);
    }
}
