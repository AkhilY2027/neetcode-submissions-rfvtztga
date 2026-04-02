class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Both ways?
        int[] output = new int[nums.length];

        // With div
        int numZeroes = 0;
        long totalProd = 1;
        for (int i = 0; i  < nums.length; i++) {
            if (nums[i] == 0) numZeroes++;
            totalProd *= nums[i];
        }

        if (numZeroes == 1) {
            // Go through and calculate product without 0
            int placeZero = -1;
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) placeZero = i;
                else product *= nums[i];
            }

            output[placeZero] = product;
        }
        else if (numZeroes == 0) {
            for (int i = 0; i < nums.length; i++) {
                output[i] = (int) (totalProd / nums[i]);
            }
        }
        return output;
    }
}  
