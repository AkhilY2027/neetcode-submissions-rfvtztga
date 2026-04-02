class Solution {
    public List<Integer> partitionLabels(String s) {
        // Basically, think of the characters in string as "ranges" from where they first appear to where they last appear
            // These need to be split up into the most substrings possible
            // I believe that if two or more ranges overlap, they must be combined into one substring
            // This way, our final total is no ranges that overlap – Our final substring
        
        // 1. Get Ranges of every character
        // HashMap<Character, int[]> charToRange = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     charToRange.putIfAbsent(c, new int[] {i, i});
        //     charToRange.get(c)[1] = i;
        // }

        // // 2. Sort ranges by beginning to end
        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a, b) -> a[0] - b[0]
        // );
        // for (char c : charToRange.keySet()) {
        //     pq.add(charToRange.get(c));
        // }

        // // 3. Combine ranges that overlap
        //     // Ranges that don't are our final answer
        // ArrayList<Integer> sol = new ArrayList<>();
        // while (!pq.isEmpty()) {
        //     int[] cur = pq.poll();
        //     while (!pq.isEmpty() && pq.peek()[0] < cur[1]) {
        //         // cur[1] = pq.poll()[1];
        //         cur[1] = Math.max(cur[1], pq.poll()[1]);
        //     }

        //     // Cur is now one of the substrings
        //     sol.add(cur[1] - cur[0] + 1);
        // }
        // return sol;


        // More efficient solution: Just go through string knowing where every character will end
            // This way, we don't have to keep the "ranges" sorted since going linearly through the string takes care of that for us
            
        // 1. Correspond every character in the string to its end index
        HashMap<Character, Integer> endIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            endIndex.put(s.charAt(i), i);
        }

        // 2. Go through string and find the last point we have to end up at
            // This is kept track via an endPointer variable
            // Keep iterating until we reach this endPointer as there could be another character to increase this endPointer
            // When we reach this endPointer, we know that the substring is done
        ArrayList<Integer> sol = new ArrayList<>();
        int curSize = 0, endPointer = 0;
        for (int i = 0; i < s.length(); i++) {
            curSize++;
            endPointer = Math.max(endPointer, endIndex.get(s.charAt(i)));

            if (i == endPointer) {
                sol.add(curSize);
                curSize = 0;
            }
        }
        return sol;
    }
}
