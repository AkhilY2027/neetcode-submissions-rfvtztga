class Solution {
    private int sumOfSquares(int n) {
        int sol = 0;
        while (n > 0) {
            int dig = n % 10;
            sol += dig * dig;
            n /= 10;
        }
        return sol;
    }
    public boolean isHappy(int n) {
        // Brute Force: HashSet
            // Time Complexity: O(logn)
            // However, Space Complexity is O(logn) as well
        // HashSet<Integer> visit = new HashSet<>();
        // while (!visit.contains(n)) {
        //     visit.add(n);
        //     n = sumOfSquares(n);
        //     if (n == 1) return true;
        // }
        // return false;

        // Better Solution: Slow and Fast Pointers
            // Have one pointer be sumofsquares of n
            // Then other pointer is sumofsquares of sumofsquares of n
            // If they match at all, then we are cycling – otherwise, return true
        int slowPointer = sumOfSquares(n);
        int fastPointer = sumOfSquares(sumOfSquares(n));
        while (slowPointer != fastPointer) {
            // if ((slowPointer == 1) || (fastPointer == 1)) return true;
            slowPointer = sumOfSquares(slowPointer);
            fastPointer = sumOfSquares(sumOfSquares(fastPointer));
        }
        return (slowPointer == 1) || (fastPointer == 1);
    }
}
