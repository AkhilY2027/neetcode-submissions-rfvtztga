class Solution {
    public void sortColors(int[] nums) {
        // Brute Force: Count colors in nums, then place in order of 0, 1, 2
        int zeroes = 0, ones = 0, twos = 0;
        for (int num : nums) {
            if (num == 0) zeroes++;
            else if (num == 1) ones++;
            else twos++;
        }
        for (int i = 0; i < zeroes; i++)
            nums[i] = 0;
        for (int i = zeroes; i < zeroes + ones; i++)
            nums[i] = 1;
        for (int i = zeroes + ones; i < nums.length; i++)
            nums[i] = 2;
    }
}