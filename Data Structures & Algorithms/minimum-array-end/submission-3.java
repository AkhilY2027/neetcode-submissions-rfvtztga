class Solution {
    public long minEnd(int n, int x) {
        // Since it is AND, the 1 for every position has to survive until the end
            // Every i + 1 has to be greater, so i + 1 has to be the one to contain the 1
            // Or rather, we start from x, then increase by keeping 1s constant
                // Need to start with x because it is always the least number to satisfy its own constraints

        // Brute Force: Just increment numbers from x to others that satisfy the constraints
            // Eventually will fill out n and find the minimum possible number
            // However, just continuously adding and checking for constraints will take a long time
                // Instead, use OR to easily find the next number that will satisfy constraints
                // Increment, then OR with original – This way, all 1s are preserved automatically
            // O(n) time
        
        // long sol = x;
        // for (int i = 1; i < n; i++)
        //     sol = x | (sol + 1);
        // return sol;

        // Optimization: Instead of counting, focus on figuring out the bits of the last index of n
            // Intuition: At the very least, we increment n - 1 times
                // But we are OR-ing anyway to find the next best number
                // Instead, flip thinking from incrementing by 1 to adding per 1-bit
                    // Ex. if n - 1 = 65, then it is actually 1 + 64 instead of 65 1s
            // Intuition 2: Only the 1 bits of x have to stay the same – rest are 0s that are increment like a normal number
            // Put Intuitions together: "Place" bitwise n - 1 into the 0 spaces within x
                // This way, we add n - 1 increments without much issue
                // Essentially a two pointer approach
            // Time Complexity: O(log_2(n))
        
        long xi = 1, ni = 1;
        long sol = x;

        while (ni <= (n - 1)) {
            if ((x & xi) == 0) {
                // Found a 0 bit - add n bit into this space
                if ((ni & (n - 1)) != 0)
                    sol |= xi;
                ni <<= 1;
            }
            xi <<= 1;
        }
        return sol;
    }
}