class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Can we not just do a hashmap, then check?

        // // 1. Get all freqencies
        // HashMap<Integer, Integer> freqMap = new HashMap<>();
        // int n = nums.length;
        // for (int i = 0; i < n; i++)
        //     freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        
        // // 2. Add those that fulfill n/3 to our final list
        // List<Integer> sol = new ArrayList<>();
        // for (int i : freqMap.keySet())
        //     if (freqMap.get(i) > (n / 3))
        //         sol.add(i);
        // return sol;

        // Possible Space Optimization: Realize the final solution has at most 2 elements
            // This is because > n/3 requires only 2 elements at most
                // Thus, we don't need to search the entire array
            // Solution: Do the same hashMap counting but continuously reduce and delete
                // This reduction will happen whenever our hashmap has more than 3 elements, since our final solution only needs 2
                // Upon this, decrement each element by 1 – then, if an element hits 0, then delete
                    // Regardless, the elements that are >n/3 will survive until the end
                // Edge case: Only 1 frequency throughout – last two elements also have one frequency
                    // Can just double check how frequently the last two elements appear – Still O(n) time

        // 1. Get frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // 2. If size becomes greater than 2, reduce and delete
            if (map.size() > 2) {
                // Create a new hashmap so we can delete elements as we're iterating
                HashMap<Integer, Integer> newMap = new HashMap<>();
                for (Map.Entry<Integer, Integer> e : map.entrySet())
                    if (e.getValue() > 1)
                        newMap.put(e.getKey(), e.getValue() - 1);
                map = newMap;
            }
        }

        // 3. Verify final numbers and put into our final solution
        List<Integer> sol = new ArrayList<>();
        for (int i : map.keySet()) {
            int freq = 0;
            for (int num : nums)
                if (num == i)
                    freq++;
            if (freq > n / 3)
                sol.add(i);
        }
        return sol;
    }
}