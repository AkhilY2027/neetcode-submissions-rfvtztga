class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Can binary search through numbers from l to r
            // At current sum, if worse, go down, if lesser, go up
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int cur = numbers[l] + numbers[r];
            if (cur == target)
                return new int[] {l + 1, r + 1};
            else if (cur < target)
                l++;
            else
                r--;
        }
        return null;
    }
}
