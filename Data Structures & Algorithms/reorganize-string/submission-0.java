class Solution {
    public String reorganizeString(String s) {
        // Basically, we need to reconstruct the string based on the frequency of every letter
            // Need to place letters in between frequent letters
            // If one letter's frequency is > half of s, then this string can't be formed
        
        // To easily do, use a maxheap to place frequent letters in between each other as much as possible
            // To ensure a letter doesn't appear twice in a row, track the "previous" element and remove it from pq temporarily
            // Then, put it back in the next loop
        
        // 1. Count frequencies
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        
        // 2. Create PQ – maxHeap to go through bigger frequencies first
            // Element: (count, letter)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        for (int i = 0; i < 26; i++)
            if (count[i] > 0)
                pq.offer(new int[]{count[i], i});
        
        // 3. Construct string
        StringBuilder sol = new StringBuilder();
        int[] prev = null; // Anything in here, cannot be used this turn – out of pq
        while (!pq.isEmpty() || prev != null) {
            if (prev != null && pq.isEmpty())
                return ""; // Next element has to be whatever is in prev, so two adjacent elements must be the same in this case – cannot solve
            
            int[] cur = pq.poll();
            sol.append((char) (cur[1] + 'a'));
            cur[0]--;

            if (prev != null) { // Add back in the previous element
                pq.offer(prev);
                prev = null;
            }

            if (cur[0] > 0) // Still have letters to put in
                prev = cur;
        }
        return sol.toString();
    }
}