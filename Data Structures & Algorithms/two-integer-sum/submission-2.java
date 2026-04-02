class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(nums[0], 0);
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(map.containsKey(target - n)) {
                // Means that the target exists
                int[] ret = new int[2];
                ret[0] = map.get(target - n);
                ret[1] = i;
                return ret;
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
