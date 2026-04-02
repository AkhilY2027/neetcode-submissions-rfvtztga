class Solution {
    private void reverseArray(int[] nums, int l, int r) {
        // Reverse nums from l to r
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate(int[] nums, int k) {
        // Brute Force: Continuously rotate by 1 until we reach k rotations

        // Easy Optimization: Put everything into a new array where we correlate the indices by (i + k) % n
            // Time Complexity: O(n), Space Complexity: O(n)
        // int n = nums.length;
        // int[] sol = new int[n];
        // for (int i = 0; i < n; i++)
        //     sol[(i + k) % n] = nums[i];
        // for (int i = 0; i < n; i++)
        //     nums[i] = sol[i];

        // Better Optimization:
            // Intuition: Split array into two sections: Before split point and after split point
                // Notice upon a reversal of the array, the before and after parts are switched
                // From here, just need to reverse each section individually to get our rotation
            // Thus, algo:
                // Reverse entire array (0 to n - 1)
                // Reverse first k elements (0 to k - 1)
                // Reverse rest of the array (k to n - 1)
            // Edge Case: If k is > n, then ensure to mod k by n so we don't go out of bounds of array
            // Time Complexity: O(n), Space Complexity: O(1)
        int n = nums.length;
        k = k % n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }
}