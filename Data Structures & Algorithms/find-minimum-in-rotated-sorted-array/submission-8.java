class Solution {
    public int findMin(int[] nums) {
        // Need to find the "split" in the sorted array
            // So compare the middle to right – if middle < right, then there is no split in second half of array
            // Otherwise in first half
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (r - l <= 1) return Math.min(nums[l], nums[r]);

            int mid = (l + r) / 2;
            if (nums[mid] < nums[(mid - 1) % n]) return nums[mid];

            if (nums[mid] < nums[r]) r = mid - 1;
            else l = mid + 1;
        }
        return nums[l];
    }
}
