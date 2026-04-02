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
        
        long sol = x;
        for (int i = 1; i < n; i++)
            sol = x | (sol + 1);
        return sol;
    }
}