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
        return recur(nums, 0);
    }
}
