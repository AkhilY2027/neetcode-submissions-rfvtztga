class Solution {
    private void kSum(int[] nums, int i, int k, long target, List<Integer> curList, List<List<Integer>> sol) {
        // Base case is when k = 2 – Invoke two sum algo here
        if (k == 2) {
            int l = i, r = nums.length - 1;
            while (l < r) {
                long curSum = nums[l] + nums[r];
                if (curSum < target)
                    l++;
                else if (curSum > target)
                    r--;
                else {
                    curList.add(nums[l]);
                    curList.add(nums[r]);
                    sol.add(new ArrayList<>(curList));
                    curList.remove(curList.size() - 1);
                    curList.remove(curList.size() - 1);
                    l++;
                    r--;

                    // To ensure we don't stop on duplicates:
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }
            }
            return;
        }

        for (int j = i; j < nums.length - (k - 1); j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            
            curList.add(nums[j]);
            kSum(nums, j + 1, k - 1, target - nums[j], curList, sol);
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Intuition: Built off of two sum, but with two more numbers
            // Cannot do the two sum algo again within a two sum, so do for loops to represent the other numbers

        // 1. Sort input array so that all duplicate numbers are next to each other
            // This way, can just increment until we reach a number that isn't a duplicate
        Arrays.sort(nums);

        // 2. Do Two Sum with two for loops to represent the other two numbers
            // Even better, generalize the solution to K-sum – this way, can find target sum for multiple values
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        kSum(nums, 0, 4, target, curList, sol);
        return sol;
    }
}