class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        // If only has positive: Want all numbers to be multiplied
            // If negative: Want two so that they can cancel out
            // Zero is a hard boundary
        // int maxProduct = 0, curProduct = 1, l = 0, r = 0;
        // while (r < nums.length) {
        //     if (nums[r] == 0) {
        //         maxProduct = Math.max(maxProduct, curProduct);
        //         r++;
        //         l = r;
        //         curProduct = 1;
        //     }
        //     else if (nums[r] < 0) {
        //         // Negative – want to find next one unless there's a zero
        //         int newProduct = curProduct * nums[r];
        //         int nextr = r + 1;
        //         while(nextr < nums.length && newProduct < 0) {
        //             newProduct *= nums[nextr];
        //             nextr++;
        //         }
        //         if (newProduct > curProduct) {
        //             // We found a better solution – continue with this
        //             curProduct = newProduct;
        //             r = nextr;
        //             l = nextr;
        //         }
        //         else {
        //             // Found nothing – skip this negative number
        //             maxProduct = Math.max(maxProduct, curProduct);
        //             r++;
        //             l = r;
        //             curProduct = 1;
        //         }
        //     }
        //     else {
        //         // Positive – just multiply
        //         curProduct *= nums[r];
        //         r++;
        //     }
        // }
        // return Math.max(maxProduct, curProduct);

        // Actually a DP Problem:
            // On a positive number, want the max product with the next elements
            // However, on negative number, want min product with next elements - then, repeat subproblem
        int sol = nums[0];
        int curMin = 1, curMax = 1;

        for (int i = 0; i < nums.length; i++) {
            int tmpProduct = curMax * nums[i];
            curMax = Math.max(Math.max(tmpProduct, nums[i] * curMin), nums[i]); // Either we start the product with this or multiply based on curMax/min (whether num is positive or negative)
            curMin = Math.min(Math.min(nums[i] * curMin, tmpProduct), nums[i]); // Same logic but for minimum
            sol = Math.max(sol, curMax);
        }
        return sol;
    }
}
