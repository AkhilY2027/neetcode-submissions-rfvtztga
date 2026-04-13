class Solution {
    private void dfs (int[] nums, int i, int curTarget, List<List<Integer>> sol, List<Integer> cur) {
        if (curTarget == 0) {
            sol.add(new ArrayList<>(cur));
            return;
        }
        if (curTarget < 0) // Can only add numbers, so this combination is kaput
            return;

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            dfs(nums, j, curTarget - nums[j], sol, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Basically just a backtracking problem
            // Sort for optimality
        Arrays.sort(nums);

        List<List<Integer>> sol = new ArrayList<>();
        dfs(nums, 0, target, sol, new ArrayList<>());
        return sol;
    }
}
