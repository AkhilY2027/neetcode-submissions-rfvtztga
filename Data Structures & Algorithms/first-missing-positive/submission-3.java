class Solution {
    public int firstMissingPositive(int[] nums) {
        // Brute Force: Check for positive numbers up to nums.length (Checking for 1, 2, ...) until we find a number that isn't within the array – O(n^2)
            // Optimization: Sort nums and use binary search for this check – O(nlogn)
            // Even better: After sorting, go linearly and check which positive number is missing in sequence (because all are ordered) – O(nlogn) time with O(1) space
        // Arrays.sort(nums);
        // int sol = 1;
        // for (int num : nums)
        //     if (sol == num)
        //         sol++;
        // return sol;
        
        // Optimization 2: Convert nums to hashset, then check for each positive number from 1 to n – O(n + n = n) time and O(n) space
        // HashSet<Integer> numSet = new HashSet<>();
        // for (int num : nums)
        //     numSet.add(num);
        // int sol = 1;
        // while (numSet.contains(sol))
        //     sol++;
        // return sol;

        // Optimization 3: O(n) time with O(1) space
            // Intuition: We only need to know if numbers from 1 to n exist within nums
                // Second Intuition: nums contains space for all numbers from 1 to n (excluding the numbers already stored within nums)
            // Thus, can use nums as our "hashset"
                // Essentially, we correspond all positive numbers from 1 to n to a 0-index scheme – thus, can easily check if nums has that number
                    // Can even drop negative numbers because they are useless
                // Problem is convertion from current nums to this scheme
            // Algo:
                // First loop, mark all negative numbers as 0 (Easily dropping negative numbers)
                // Second loop, take every number, then go to index of abs(num) - 1
                    // If this is out of bounds, then nothing should happen
                    // If this is within bounds, then mark this specific number as negative
                        // Reason we have to do like this is because two numbers can correspond to each other's indices – thus, using negative signs as "marks"
                        // If number here is already negative, do not change it back to a positive
                    // Edge case: If this number is 0, then must change this number to a negative number
                        // Since we can still be searching through the array, must be a number that will be out of bounds upon an index calculation
                        // Thus, if this number is 0, set to -(n + 1)
                // Third loop, we are doing the loop of checking all positive numbers
                    // Checking indices 0 to n - 1 for numbers
                    // If this number is negative, it means we found the corresponding positive number (contained somewhere else within the list)
            
        // 1. First loop
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] < 0)
                nums[i] = 0;
        
        // 2. Second loop
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < 0 || index >= n)
                continue;
            if (nums[index] == 0)
                nums[index] = -(n + 1);
            else if (nums[index] > 0)
                nums[index] *= -1;
        }

        // 3. Third loop
        for (int i = 1; i <= n; i++)
            if (nums[i - 1] >= 0)
                return i;
        return n + 1;
    }
}