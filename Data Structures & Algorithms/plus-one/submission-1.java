class Solution {
    public int[] plusOne(int[] digits) {
        // int carry = 1;
        // ArrayList<Integer> sol = new ArrayList<>();
        // for (int i = digits.length - 1; i >= 0; i--) {
        //     // Go through each number and add 1 - carry over
        //     int newNum = digits[i] + carry;
        //     // digits[i] = newNum % 10;
        //     sol.add(0, newNum % 10);
        //     carry = newNum / 10;
        // }
        // if (carry != 0) sol.add(0, carry);
        // // return digits;
        // int[] ret = new int[sol.size()];
        // for (int i = 0; i < sol.size(); i++) {
        //     ret[i] = sol.get(i);
        // }
        // return ret;

        // Either: Will carry 1 and continue program
            // Or: Don't carry 1 and return as is
            // Edge case: Exceed bounds of array - can only be a multiple of ten
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) { // Either add or becomes 0
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // If we get here, then the result is always 100000...
        int[] sol = new int[digits.length + 1];
        sol[0] = 1;
        return sol;
    }
}
