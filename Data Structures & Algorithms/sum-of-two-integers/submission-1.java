class Solution {
    public int getSum(int a, int b) {
        // Have to do bit manipulation tricks
        while (b != 0) {
            int carry = (a & b) << 1; // Bits that will be lost with the XOR operation
            a ^= b;
            b = carry;
        }
        return a;
    }
}
