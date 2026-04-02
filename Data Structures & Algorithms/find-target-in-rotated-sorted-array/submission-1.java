class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // Basically, just keep checking middle
            int m = (l + r) / 2;
            if (nums[m] == target) return m;

            // Otherwise, know where to recurse
            if (nums[l] <= nums[m]) {
                // l to m is ascending with no break
                if (target > nums[m] || target < nums[l]) l = m + 1;
                else r = m - 1;
            }
            else {
                // m to r is ascending with no break
                if (target < nums[m] || target > nums[r]) r = m - 1;
                else l = m + 1;
            }
        }
        return -1;
    }
}
