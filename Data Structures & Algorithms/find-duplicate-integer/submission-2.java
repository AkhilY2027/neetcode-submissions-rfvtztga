class Solution {
    public int findDuplicate(int[] nums) {
        // O(n) time + space complexity
        // HashSet<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     if (set.contains(num)) return num;
        //     set.add(num);
        // }
        // return -1;

        // O(n) time complexity + O(1) space complexity

        // Rough Draft
        // long sum = 0;
        // int maxNum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     maxNum = Math.max(maxNum, nums[i]);
        // }
        // for (int i = 1; i <= maxNum; i++) {
        //     sum -= i;
        // }
        // return (int) sum / (nums.length - maxNum);

        // Floyd's Tortoise and Hare Algorithm
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int sslow = 0;
        while (slow != sslow) {
            slow = nums[slow];
            sslow = nums[sslow];
        }
        return slow;
    }
}
