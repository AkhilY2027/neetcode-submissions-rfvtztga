class Solution {
    private void dfs(List<List<Integer>> sol, List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            sol.add(new ArrayList<>(cur));
            return;
        }
        // Go through all remaining possibilities
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            cur.add(nums[i]);
            dfs(sol, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // Just do backtracking solution
            // To make sure we don't repeat nums, use a separate array of booleans to keep track of those inside our dfs
        List<List<Integer>> sol = new ArrayList<>();
        dfs(sol, new ArrayList<>(), nums, new boolean[nums.length]);
        return sol;
    }
}
