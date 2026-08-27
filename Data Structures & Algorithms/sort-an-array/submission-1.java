class Solution {
    private int[] mergeSort(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new int[] {nums[l]};
        // Split
        int m = (l + r) / 2;
        int[] left = mergeSort(nums, l, m);
        int[] right = mergeSort(nums, m + 1, r);

        // Merge
            // Go through and create a new array corresponding to sorted elements
        int lPointer = 0, rPointer = 0, solPointer = 0;
        int[] sol = new int[(r - l) + 1];
        while (solPointer < sol.length) {
            if (lPointer == left.length)
                sol[solPointer++] = right[rPointer++];
            else if (rPointer == right.length)
                sol[solPointer++] = left[lPointer++];
            else {
                if (left[lPointer] < right[rPointer])
                    sol[solPointer++] = left[lPointer++];
                else
                    sol[solPointer++] = right[rPointer++];
            }
        }
        return sol;
    }
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}