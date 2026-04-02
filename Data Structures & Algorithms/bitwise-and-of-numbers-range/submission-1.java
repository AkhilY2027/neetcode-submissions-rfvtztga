class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // // O(n) solution
        // int sol = left;
        // for (int i = left + 1; i <= right; i++)
        //     sol &= i;
        // return sol;

        // Possible O(1) solution
            // This is an AND operation, so power of 2 needs to be present in all numbers
            // Maybe we can do a floor log of 2 and see what we get?
                // If left and right have the same floor log of 2, that means there is a power of 2 guarenteed to be the same?
            // However, how do we guarentee the numbers outside of the biggest power of 2 is correct?
        
        // Solution: Similar to above intuition
            // Look at each bit of left number -> If we don't guarentee that the number will be a 0 in range until right, then we say it's a one
            // We can do this by seeing how much we need to add to that bit to transform it from a 1 to a 0
                // If (right - left) >= addition, we guarentee there is a 0 in the range -> for solution, that bit is 0
            // Repeat this 32 times
        int sol = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (left >> i) & 1; // Get the ith bit of left
            if (bit == 0) continue;

            // Find the additions we need to make this bit a 0
                // 1. Get the number with next significant bit – 
                // 2. Get the part of left that includes current bit and less – left % (1 << (i + 1))
                    // This gets us only bits before next significant bit
            int additions = (1 << (i + 1)) - (left % (1 << (i + 1)));

            // See if our range covers that amount
            if ((right - left) < additions)
                sol |= (1 << i);
        }
        return sol;
    }
}