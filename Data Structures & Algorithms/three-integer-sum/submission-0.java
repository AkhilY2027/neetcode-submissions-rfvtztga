class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // int sol = 0;
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // At this point, since array is sorted, cannot use any negative numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Now, do a binary search for perfect indices of target
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                if (cur == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    sol.add(temp);


                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++; // Ensure no duplicates
                    r--;
                }
                else if (cur > 0) {
                    // We know that left is usually negative + right is usually positive
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return sol;
    }
}
