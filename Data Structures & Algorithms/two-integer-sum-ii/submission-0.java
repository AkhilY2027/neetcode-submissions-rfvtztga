class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];

        // Brute force solution
        for(int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    sol[0] = i + 1;
                    sol[1] = j + 1;
                    return sol;
                }
            }
        }
        return sol;
    }
}
