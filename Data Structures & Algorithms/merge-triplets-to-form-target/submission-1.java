class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Basically, the target becomes the "limit"
            // Consider each a, b, and c different arrays column-wise
            // Take each array that is within the "limit"
            // Then, if there's overlap - that means that the target can be created
        
        // HashSet<Integer> a = new HashSet<>();
        // HashSet<Integer> b = new HashSet<>();
        // HashSet<Integer> c = new HashSet<>();

        // // Now, loop through
        // for (int i = 0; i < triplets.length; i++) {
        //     if (triplets[i][0] <= target[0]) a.add(i);
        //     if (triplets[i][1] <= target[1]) b.add(i);
        //     if (triplets[i][2] <= target[2]) c.add(i);
        // }

        // // Get the intersection of all three hashsets
        // a.retainAll(b);
        // a.retainAll(c);
        // // return !a.isEmpty();
        // return a.size() == 1;


        // Actual Solution: Loop through with the limits as per usual but with altered conditions
            // Any triplet with a number exceeding the limit is not added to the hashset
            // Only add to the hashset if the triplet number contains the target number
                // This way, can ensure that the triplets can combine into that target number

        // HashSet<Integer> set = new HashSet<>();

        // for (int i = 0; i < triplets.length; i++) {
        //     if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
        //         continue; // Don't want any numbers above our limits

        //     // Now, check if any of the numbers within this valid triplet are equal to our target values
        //         // This way, we can combine them into our target
        //     for (int j = 0; j < target.length; j++) {
        //         if (triplets[i][j] > target[j])
        //             set.add(j);
        //     }
        // }

        // // Now, check if the remaining size - ie valid target numbers found - is equal to 3
        //     // Length of the triplet
        // return set.size() == 3;


        // Even better solution: Use booleans to check if we have met the conditions
            // This way, don't need to use a hashset that will be o(n)

        boolean a = false, b = false, c = false;

        for (int[] triple: triplets) {
            a |= (triple[0] == target[0] && triple[1] <= target[1] && triple[2] <= target[2]);
            b |= (triple[0] <= target[0] && triple[1] == target[1] && triple[2] <= target[2]);
            c |= (triple[0] <= target[0] && triple[1] <= target[1] && triple[2] == target[2]);
            if (a && b && c) return true;
        }
        return false;
    }
}
