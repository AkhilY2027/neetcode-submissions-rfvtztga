class Solution {
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);

        // Use bit masking
        int sol = 0;
        while (n != 0) {
            // sol += n % 2; // If n is odd, there will be a number in first bit
            // n = n >> 1; // Since we're using bits and dividing by 2, just shift

            // Little more efficient: (Skips all 0s)
            n &= (n - 1); // Always zeros out the number until the next 1 bit
                // If confused, try examples with 1 bits spread between lots of 0s
            sol++;
        }
        return sol;
    }
}
