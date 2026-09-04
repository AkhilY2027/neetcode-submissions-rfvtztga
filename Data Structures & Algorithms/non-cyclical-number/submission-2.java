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
        HashSet<Integer> visited = new HashSet<>();
        while (n > 1) {
            visited.add(n);
            n = squares(n);
            if (visited.contains(n))
                return false;
        }
        return true;
    }
}
