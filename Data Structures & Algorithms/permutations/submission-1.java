class Solution {
    public void backTrack(int[] nums, List<List<Integer>> sol, List<Integer> cur) {
        // Recursive function will continuously find the 
    }
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return Arrays.asList(new ArrayList<>());

        // Basically, we recurse all the previous combiniations (with one less number, and then we add them back in to all combiniations found)
            // Time Complexity - O(n! * n^2)
            // Space Complexity - O(n! * n)
        List<List<Integer>> sol = new ArrayList<>();
        List<List<Integer>> prev = permute(Arrays.copyOfRange(nums, 1, nums.length));

        for (List<Integer> p : prev) {
            // Add nums[0] to every list at any point
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> to_add = new ArrayList<>(p);
                to_add.add(i, nums[0]);
                sol.add(to_add);
            }
        }

        return sol;
    }
}
