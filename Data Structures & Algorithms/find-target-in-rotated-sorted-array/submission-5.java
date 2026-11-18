class Solution {
    public int search(int[] nums, int target) {
        // Want an updated binary search
            // However, there is a "split" in the middle of the array
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            // Two possibilities:
                // l to m is completely ascending
                // or m + 1 to r is completely ascending
            // Thus, we know where to recurse
            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) l = m + 1; // Not in the ascending part – completely skip
                else r = m - 1;
            }
            else {
                if (target < nums[m] || target > nums[r]) r = m - 1; // Not in the ascending part – completely skip
                else l = m + 1;
            }
        }
        return -1;
    }
}
