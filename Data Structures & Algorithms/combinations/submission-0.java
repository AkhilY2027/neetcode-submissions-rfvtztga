class Solution {
    private void dfs(int i, int n, int k, List<Integer> cur, List<List<Integer>> sol) {
        if (cur.size() == k) { // Shouldn't be able to go beyond k with this
            sol.add(new ArrayList<>(cur));
            return;
        }
        if (i > n) return;

        // Either add this or don't
        dfs(i + 1, n, k, cur, sol);

        // Add
        cur.add(i);
        dfs(i + 1, n, k, cur, sol);
        cur.remove(cur.size() - 1);
    }
    public List<List<Integer>> combine(int n, int k) {
        // So just... decision tree
        List<List<Integer>> sol = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), sol);
        return sol;
    }
}