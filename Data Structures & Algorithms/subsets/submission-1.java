class Solution {
    public void backTrack(int[] nums, int index, List<Integer> curList, List<List<Integer>> sol) {
        if (index == nums.length) {
            sol.add(new ArrayList<>(curList));
            return;
        }

        // Either add or don't
        curList.add(nums[index]);
        backTrack(nums, index + 1, curList, sol);
        curList.remove(curList.size() - 1);
        backTrack(nums, index + 1, curList, sol);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), sol);
        return sol;
    }
}
