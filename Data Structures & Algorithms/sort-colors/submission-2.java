class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        // // Brute Force: Count colors in nums, then place in order of 0, 1, 2
        // int zeroes = 0, ones = 0, twos = 0;
        // for (int num : nums) {
        //     if (num == 0) zeroes++;
        //     else if (num == 1) ones++;
        //     else twos++;
        // }
        // for (int i = 0; i < zeroes; i++)
        //     nums[i] = 0;
        // for (int i = zeroes; i < zeroes + ones; i++)
        //     nums[i] = 1;
        // for (int i = zeroes + ones; i < nums.length; i++)
        //     nums[i] = 2;

        // What about a one-pass algorithm?
            // Easy: Swap number to beginning of array when there's a 0 and end when there's a 2
        int i = 0, l = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) { // Send 0 to the beginning
                swap(nums, i, l);
                l++;
                // Don't need to decrement i here because we know any element before i is already sorted properly
            }
            else if (nums[i] == 2) { // Send 2 to the end
                swap(nums, i, r);
                r--;
                i--; // Also need to decrease i since we're incrementing it later – need to redo the current element
            }
            i++;
        }
    }
}