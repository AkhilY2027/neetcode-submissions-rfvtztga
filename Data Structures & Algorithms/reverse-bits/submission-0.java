class Solution {
    public int reverseBits(int n) {
        int sol = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 0b1;
            if (temp == 1)
                sol |= temp << (31 - i);
            n = n >> 1;
        }
        return sol;
    }
}
