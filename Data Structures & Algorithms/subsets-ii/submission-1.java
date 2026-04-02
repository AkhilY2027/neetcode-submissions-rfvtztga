class Solution {
    public void backTrack(Set<List<Integer>> set, int len, int curIndex, int[] nums, List<Integer> curList) {
        // Basically, go through all possible combinations
        if (len == curList.size()) {
            // First, ensure the new ArrayList is in numerical order
            List<Integer> temp = new ArrayList<Integer>(curList);
            Collections.sort(temp);
            set.add(temp);
            return;
        }
        if (curIndex >= nums.length) { // Exceeded the bounds
            return;
        }

        // Then, either add the current element, or don't add
        // Add:
        curList.add(nums[curIndex]);
        backTrack(set, len, curIndex + 1, nums, curList);
        curList.remove(curList.size() - 1);

        // Don't Add:
        backTrack(set, len, curIndex + 1, nums, curList);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        // Basically, get all possible subsets and add them to the hashset
        for (int i = 0; i <= nums.length; i++) {
            // Specifies the number of elements in each subset - BackTracking
            backTrack(set, i, 0, nums, new ArrayList<Integer>());
        }

        // Then, at the end, convert from hashset to list again
        return new ArrayList<List<Integer>>(set);
    }
}
