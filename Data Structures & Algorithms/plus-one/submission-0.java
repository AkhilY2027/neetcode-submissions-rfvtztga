class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            // Go through each number and add 1 - carry over
            int newNum = digits[i] + carry;
            // digits[i] = newNum % 10;
            sol.add(0, newNum % 10);
            carry = newNum / 10;
        }
        if (carry != 0) sol.add(0, carry);
        // return digits;
        int[] ret = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            ret[i] = sol.get(i);
        }
        return ret;
    }
}
