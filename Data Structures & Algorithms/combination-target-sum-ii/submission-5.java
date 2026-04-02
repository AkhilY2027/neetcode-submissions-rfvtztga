class Solution {
    private void dfs(int[] candidates, int i, int curSum, List<List<Integer>> sol, List<Integer> cur) {
        if (curSum == 0) {
            sol.add(new ArrayList<>(cur));
            return;
        }
        if (curSum < 0 || i >= candidates.length)
            return;

        // Two options:
        // 1. Include currrent element and move to next (Can include duplicates)
        cur.add(candidates[i]);
        dfs(candidates, i + 1, curSum - candidates[i], sol, cur);
        cur.remove(cur.size() - 1);
        // 2. Exclude current element and move to next (Do not include duplicates)
        int j = i + 1;
        while (j < candidates.length && candidates[j] == candidates[i])
            j++;
        dfs(candidates, j, curSum, sol, cur);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort candidates and then do a dfs essentially
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, sol, new ArrayList<>());
        return sol;
    }
}