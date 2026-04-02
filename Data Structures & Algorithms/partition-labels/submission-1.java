class Solution {
    public List<Integer> partitionLabels(String s) {
        // Basically, all letters of one type need to be included in one string
            // You can represent this as a "start" index and "end" index for each index
            // If any indeces overlap, you have to combine them - Leads to lengths

        // HashMap<Character, int[]> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (map.containsKey(c)) {
        //         map.get(c)[1] = i;
        //     }
        //     else {
        //         map.put(c, new int[] {i, i});
        //     }
        // }

        // // Now, we have to find the indeces that overlap with each other
        // ArrayList<int[]> indeces = new ArrayList<>(map.values());
        // indeces.sort( (a, b) -> { return a[0] - b[0]; } ); // Now, in sorted start value order
        // int i = 0;
        // ArrayList<Integer> sizes = new ArrayList<>();
        // while(i < indeces.size()) {
        //     int startVal = indeces.get(i)[0];
        //     int endVal = indeces.get(i)[1];
        //     while(i + 1 < indeces.size() && indeces.get(i + 1)[0] < endVal) {
        //         endVal = indeces.get(i + 1)[1];
        //         i++;
        //     }
        //     sizes.add(endVal - startVal + 1);
        //     i++;
        // }
        // return sizes;

        // Actual Solution: Correspond each character in the string to its end index
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        // Then, go through the string again and continuously keep track of an "end" pointer
            // This will point to the end index for each character and updates with each character found
            // If the iteration reaches the end pointer, we know its a substring and record the length
        ArrayList<Integer> sizes = new ArrayList<>();
        int curSize = 0, endPointer = 0;
        for (int i = 0; i < s.length(); i++) {
            curSize++;
            endPointer = Math.max(endPointer, lastIndex.get(s.charAt(i)));

            if (i == endPointer) {
                sizes.add(curSize);
                curSize = 0;
            }
        }
        return sizes;
    }
}
