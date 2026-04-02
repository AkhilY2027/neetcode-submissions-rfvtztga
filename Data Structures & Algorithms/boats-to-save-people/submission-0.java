class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Brute force: Check every combination of people that could work and make them boats
            // O(2^n)?
        
        // Ideal: Want to group together people that are closest in weight so boats can make the most of their limit
            // How about a sort, then left and right pointers?
        
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int sol = 0;
        while (l <= r) {
            // Try to combine left and right – if it exceeds the limit, then only take the right
            sol++;
            if (people[l] + people[r] <= limit)
                l++;
            r--;
        }
        return sol;
    }
}