class Solution {
    private void dfs(int[] nums, List<Integer> cur, HashMap<Integer, Integer> numCounts, List<List<Integer>> sol) {
        if (cur.size() >= nums.length) {
            sol.add(new ArrayList<>(cur));
            return;
        }

        for (int num : numCounts.keySet()) {
            // Have to go through and see what numbers are available – O(n) operation
            if (numCounts.get(num) > 0) {
                cur.add(num);
                numCounts.put(num, numCounts.get(num) - 1);
                dfs(nums, cur, numCounts, sol);
                numCounts.put(num, numCounts.get(num) + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        // If it was permutations without duplicates, we just use a decision tree
            // However, unless we use a set, we can't do so because we get duplicates of permutations
        
        // Ultimately, cannot use duplicates in the same positions

        // Solution: Create a HashMap of nums counts
            // Do a decision tree with this hashmap, updating the map as we go down decisions
            // This way, by decrementing the counts at every tree branch, we don't make the same permutations per branch
        
        // 1. Create a hashmap of counts
        HashMap<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);

        // 2. DFS
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, cur, numCounts, sol);
        return sol;
    }
}