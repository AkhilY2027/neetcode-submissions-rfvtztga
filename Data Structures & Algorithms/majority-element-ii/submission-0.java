class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Can we not just do a hashmap, then check?

        // 1. Get all freqencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        
        // 2. Add those that fulfill n/3 to our final list
        List<Integer> sol = new ArrayList<>();
        for (int i : freqMap.keySet())
            if (freqMap.get(i) > (n / 3))
                sol.add(i);
        return sol;
    }
}