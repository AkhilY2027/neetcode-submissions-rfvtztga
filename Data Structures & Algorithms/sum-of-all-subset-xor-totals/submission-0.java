class Solution {
    public int subsetXORSum(int[] nums) {
        if (nums.length == 0) return 0;

        // // Do a sliding window for each length of nums
        // int sum = 0;
        // for (int s = 1; s <= nums.length; s++) {
        //     int l = 0, r = 0;
        //     int curXOR = 0;
        //     while (r < nums.length) {
        //         // If longer than our current size, then we have to update l and XOR it out
        //         while ((r - l + 1) > s) {
        //             curXOR ^= nums[l];
        //             l++;
        //         }

        //         // Add current num to our sliding sum
        //         curXOR ^= nums[r];

        //         // Add this current XOR to the sum
        //         if ((r - l + 1) == s) {
        //             System.out.println(curXOR);
        //             sum += curXOR;
        //         }
        //         r++;
        //     }
        // }
        // return sum;

        // Since it's subsets, do a dfs – O(2^n)

        // However, far easier to do an O(n) solution
            // Intuition: Combinatorics
            // Know that for every number, have of total subsets will have it, and half won't
            // Can now think about it in the bit form of the final solution
                // For every bit in a XOR number, how many combinations of subsets will that bit be one?
                // Ex. The 1st bit only has one possibility of one (Only one number in nums has a 1 at that point)
                    // This leads to 2^(n - 1) subsets where there is a one in that spot -> 2^(n - 1) sum
                // However, if we introduce another number that has a one in the same place...
                    // Still 2^(n - 1), half the time, the other number will cancel out the 1, and half the time, the other number will XOR a 0 with a 1
                // Thus, every bit (so long there is a 1 for that bit in one of the nums) has 2^(n - 1) possibilities

        // Thus, our solution is:
            // First, need all bits that have a one – Can find via OR-ing the entire nums array (We get the initial sample)
            // Then, shift those 1s by 2^(n - 1)
                // In other words, << (n - 1)
        int sol = 0;
        for (int num : nums)
            sol |= num;
        return sol << (nums.length - 1);
    }
}