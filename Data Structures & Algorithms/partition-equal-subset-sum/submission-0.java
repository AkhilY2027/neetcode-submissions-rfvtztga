class Solution {
    public boolean backTrack(int[] nums, int curIndex, int curSum, int sum) {
        if (curSum > sum) return false;
        if (curIndex >= nums.length) return false;
        if (curSum == sum) return true;

        return backTrack(nums, curIndex + 1, curSum + nums[curIndex], sum) | backTrack(nums, curIndex + 1, curSum, sum);
    }
    public boolean canPartition(int[] nums) {
        // In other words, is there a subset within nums that sums up to half of nums?
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false; // Cannot split if sum is odd

        return backTrack(nums, 0, 0, sum / 2);
    }
}
