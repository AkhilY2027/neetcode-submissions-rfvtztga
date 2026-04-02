class Solution {
    private boolean bruteForceBackTracking(int i, int[] nums, int[] kArr, int sumToReach) {
        if (i >= nums.length) {
            // Check if all k elements are equal to each other
            for (int ki : kArr)
                if (ki != sumToReach)
                    return false;
            return true;
        }

        // Add this current element to each possible part of kArr and see if we can reach the end properly
        boolean sol = false;
        for (int ki = 0; ki < kArr.length; ki++) {
            kArr[ki] += nums[i];
            sol |= bruteForceBackTracking(i + 1, nums, kArr, sumToReach);
            kArr[ki] -= nums[i];
        }
        return sol;
    }

    private boolean optimizedBackTrack(int i, int[] nums, int curSum, int sumToReach, int k, HashSet<Integer> visited) {
        if (k == 0) return true;
        if (curSum == sumToReach) return optimizedBackTrack(0, nums, 0, sumToReach, k - 1, visited);

        // Either add an element or not
        for (int j = i; j < nums.length; j++) {
            if (visited.contains(j) || (curSum + nums[j] > sumToReach))
                continue;
            
            visited.add(j);
            if (optimizedBackTrack(j + 1, nums, curSum + nums[j], sumToReach, k, visited))
                return true;
            visited.remove(j);
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Need k groups of sumToReach
        int sumToReach = 0;
        for (int num : nums)
            sumToReach += num;
        if (sumToReach % k != 0) return false;
        sumToReach /= k;

        // Intuition: Cannot just sort and sum, as there is no definitive property on how these subsets can be formed
            // Ex. Largest element doesn't have to be paired with the smallest for example
            // Can only combine elements and see if the subsets exist

        // Brute Force: Backtracking – O(k^n)
            // Have an array of k elements that represent the subset
            // Want to go through nums such that we add each num of nums into each possible k element and see if we can reach a solution
        // return bruteForceBackTracking(0, nums, new int[k], sumToReach);

        // Optimization: (k * 2^n)
            // Basically, we try to make sumToReach by going through nums and either including/excluding a num
            // Then, do it again k times
                // On next iterations, cannot use the indices used in first solution – Use a visited hashset
            // Be warned: There can be multiple ways to form a k
                // And subsetting one way can lock other ways out
                // Thus, the backtracking function must also backTrack within itself for a k
        return optimizedBackTrack(0, nums, 0, sumToReach, k, new HashSet<>());
    }
}