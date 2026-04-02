class Solution {
    public int reverseBits(int n) {
        int sol = 0;
        // Since sol is signed, have to be careful in how we add the bits to it
        for (int i = 0; i < 32; i++) {
            sol |= (n & 0b1) << (31 - i);
            n = n >> 1;
        }
        return sol;
    }
}
