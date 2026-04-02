class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];

        // Brute force solution - O(n^2)
        // for(int i = 0; i < numbers.length - 1; i++) {
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             sol[0] = i + 1;
        //             sol[1] = j + 1;
        //             return sol;
        //         }
        //     }
        // }

        // Second solution: Sort array and then search for indecies - O(nlogn)
            // Nevermind, apparently guarenteed that the arrays are sorted - O(n)
        // Arrays.sort(numbers);
        int first = 0;
        int second = numbers.length - 1;
        while(first < second) {
            int sum = numbers[first] + numbers[second];
            if (sum == target) {
                sol[0] = first + 1;
                sol[1] = second + 1;
                return sol;
            }
            else if (sum < target) {
                first += 1;
            }
            else {
                second -= 1;
            }
        }

        // Third solution: Hashmap - O(n)
            // However, space complexity is also O(n), not O(1)
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < numbers.length; i++) {
        //     int corres = target - numbers[i];
        //     // First, check if the corresponding number is in the map
        //     if(map.containsKey(corres)) {
        //         sol[0] = map.get(corres);
        //         sol[1] = i + 1;
        //         return sol;
        //     }
        //     map.put(numbers[i], i + 1);
        // }
        return sol;
    }
}
