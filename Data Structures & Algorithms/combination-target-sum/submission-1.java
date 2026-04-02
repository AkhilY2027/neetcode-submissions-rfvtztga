class Solution {
    public void dfs(int[] nums, int curIndex, int curTarget, List<Integer> curSum, List<List<Integer>> sol) {
        if (curTarget == 0) {
            sol.add(new ArrayList<>(curSum));
            return;
        }
        if (curTarget < 0) return;

        for (int i = curIndex; i < nums.length; i++) {
            // Basically, just add the number
            curSum.add(nums[i]);
            dfs(nums, i, curTarget - nums[i], curSum, sol);
            curSum.remove(curSum.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<>(), sol);
        return sol;
    }
}
