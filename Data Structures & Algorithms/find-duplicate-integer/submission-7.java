class Solution {
    public int findDuplicate(int[] nums) {
        // Because all nums are guarenteed to be within 1 to n, which is length of the array, can treat this as cycle detection problem
            // Thus, can use fast and slow pointers
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }

        // Now, after detecting cycle, use cycle property to find the "entry" point of cycle to find the actual duplicate number
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2)
                break;
        }
        return slow;
    }
}
