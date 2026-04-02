class Solution {
    public int getSum(int a, int b) {
        // Should be bit manipulation, just don't know how to do it from right to left
            // Oh wait, just shift on every loop

        int carry_digit = 0;
        int sol = 0;
        for (int i = 0; i < 32; i++) {
            int a_digit = (a >> i) & 1;
            int b_digit = (b >> i) & 1;
            int cur_digit = a_digit ^ b_digit ^ carry_digit;
            carry_digit = (a_digit + b_digit + carry_digit >= 2) ? 1 : 0;
            sol |= ((cur_digit & 1) << i);
        }

        // While there won't be a case of integer overflow, we could be adding two negative numbers together
            // Thus, we need to do two's complement on the result
        if (sol > 0x7FFFFFFF)
            sol = ~(sol ^ 0xFFFFFFFF);
        return sol;
    }
}
