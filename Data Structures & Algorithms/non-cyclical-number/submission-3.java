class Solution {
    private int squares(int n) {
        int sol = 0;
        while (n > 0) {
            sol += (n % 10) * (n % 10);
            n /= 10;
        }
        return sol;
    }

    public boolean isHappy(int n) {
        // Brute Force:
        // HashSet<Integer> visited = new HashSet<>();
        // while (n > 1) {
        //     visited.add(n);
        //     n = squares(n);
        //     if (visited.contains(n))
        //         return false;
        // }
        // return true;

        // Slow and Fast Pointers
        int slow = n, fast = squares(n);
        while (slow != fast) {
            fast = squares(fast);
            fast = squares(fast);
            slow = squares(slow);
        }
        return fast == 1; // When slow catches up to fast, is it at 1?
    }
}
