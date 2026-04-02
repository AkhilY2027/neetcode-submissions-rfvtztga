class Solution {
    public int[] productExceptSelf(int[] nums) {
        // // With div
        // int[] output = new int[nums.length];
        // int numZeroes = 0;
        // long totalProd = 1;
        // for (int i = 0; i  < nums.length; i++) {
        //     if (nums[i] == 0) numZeroes++;
        //     totalProd *= nums[i];
        // }

        // if (numZeroes == 1) {
        //     // Go through and calculate product without 0
        //     int placeZero = -1;
        //     int product = 1;
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] == 0) placeZero = i;
        //         else product *= nums[i];
        //     }

        //     output[placeZero] = product;
        // }
        // else if (numZeroes == 0) {
        //     for (int i = 0; i < nums.length; i++) {
        //         output[i] = (int) (totalProd / nums[i]);
        //     }
        // }

        // Without div
        int[] output1 = new int[nums.length];
        Arrays.fill(output1, 1);
        for (int i = 1; i < nums.length; i++) {
            output1[i] = nums[i - 1] * output1[i - 1];
        }
        // [1,2,4,6] -> [1,1,2,8]
        int[] output2 = new int[nums.length];
        Arrays.fill(output2, 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            output2[i] = nums[i + 1] * output2[i + 1];
        }
        // [1,2,4,6] -> [48,24,6,1]
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for (int i = 0; i < nums.length; i++) {
            // Multiply all
            output[i] = output1[i] * output2[i];
        }

        return output;
    }
}  
