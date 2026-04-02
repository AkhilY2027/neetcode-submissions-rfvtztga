class Solution {
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElement(int[] nums, int val) {
        // Want to do in place so can't simply move to another array
            // Do not need to return original order – Can possibly just swap with the end
        // int l = 0, r = nums.length - 1;
        // while (l <= r) {
        //     if (nums[l] == val) {
        //         swap(nums, l, r);
        //         r--;
        //     }
        //     l++;
        // }
        // return l;

        // Actually, do have to return in-order
            // Instead, act as if we're replacing another array with the non-val elements of this one, except we're using the same array
            // Thus, both the non-val and val elements get overwritten every time
            // So we ensure the first k elements don't have any val elements in them, but anyone's guess for the rest
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}