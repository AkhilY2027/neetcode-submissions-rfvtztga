class Solution {
    public void dfs(int[] nums, int curIndex, int curTarget, List<Integer> curSum, List<List<Integer>> sol) {
        // if (curIndex == nums.length - 1) {
        //     System.out.println("Current: " + curSum.toString());
        // }
        if (curTarget == 0) {
            // if (curIndex == nums.length - 1) {
            //     System.out.println("Adding: " + curSum.toString());
            // }
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
        // for (int i = 0; i < nums.length; i++) {
        //     dfs(nums, i, target, new ArrayList<>(), sol);
        // }
        dfs(nums, 0, target, new ArrayList<>(), sol);
        return sol;
    }
}
