class Solution {
    public int[] plusOne(int[] digits) {
        // Basically just carry until we can't
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If we're here, then we have found a '99...9' number – need to add one to new n + 1 array
        int[] sol = new int[digits.length + 1];
        sol[0] = 1;
        return sol;
    }
}
