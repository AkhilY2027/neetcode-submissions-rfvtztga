class Solution {
    public void reset(int[] orig, int[] copy) {
        for(int i = 0; i < orig.length; i++) {
            copy[i] = orig[i];
        }
    }
    public boolean checkInclusion(String s1, String s2) {
        // Two conditions: All letters are present, consecutively
            // Optimization: Use a HashMap for the letter count
        // int[] s1LetterCount = new int[26];
        // for (char c: s1.toCharArray()) {
        //     s1LetterCount[c - 'a']++;
        // }
        // int lettersToFind = s1.length();
        // int[] count = new int[26];
        // int lettersFound = s1.length();
        // reset(s1LetterCount, count);

        // // Go through string
        // for (int i = 0; i < s2.length(); i++) {
        //     char c = s2.charAt(i);
        //     if (count[c - 'a'] <= 0) {
        //         // Then, we have to reset - Did not find a permutation
        //         if (lettersFound < s1.length()) {
        //             reset(s1LetterCount, count);
        //             lettersFound = s1.length();
        //         }
        //     }
        //     else {
        //         // Here, we have letters in the permutation that we can see
        //         count[c - 'a']--;
        //         lettersFound--;
        //         if (lettersFound <= 0)
        //             return true;
        //     }
        // }
        // return false;

        // Optimization: Use a HashTable
            // Time is O(n * m) + Space Complexity of O(1) since we will always only be storing the alphabet
        // HashMap<Character, Integer> s1LetterCount = new HashMap<>();
        // for (char c : s1.toCharArray()) {
        //     s1LetterCount.put(c, s1LetterCount.getOrDefault(c, 0) + 1);
        // }
        // int lettersToFind = s1LetterCount.size();

        // for (int i = 0; i < s2.length(); i++) {
        //     // Go through all possible combinations of strings
        //     Map<Character, Integer> count = new HashMap<>();
        //     int curCount = 0;
        //     for (int j = i; j < s2.length(); j++) {
        //         // Get the letter
        //         char c = s2.charAt(j);
        //         count.put(c, count.getOrDefault(c, 0) + 1);

        //         if (s1LetterCount.getOrDefault(c, 0) < count.get(c)) {
        //             // Overshot - Not a permutation so move onto next i loop
        //             break;
        //         }
        //         if (s1LetterCount.getOrDefault(c, 0) == count.get(c)) {
        //             curCount++; // Number of letters found
        //         }

        //         if (curCount == lettersToFind)
        //             return true;
        //     }
        // }
        // return false;

        // Second Optimization: Sliding Window (Essentially two pointers)
        // Part 1: Get all consecutive windows of s1 length and compare the strings together
            // O(26 * n)
        if (s1.length() > s2.length()) return false; // Impossible

        char[] cArr = s1.toCharArray();
        Arrays.sort(cArr);
        String sortedS1 = new String(cArr);

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            char[] cArr2 = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(cArr2);
            String sortedCurString = new String(cArr2);
            if (sortedS1.equals(sortedCurString))
                return true;
        }
        return false;

        // int[] s1Count = new int[26];
        // int[] s2Count = new int[26];
        // for (char c: s.toCharArray()) {
        //     s1Count[c - 'a']++;
        //     s2Count[c - 'a']++;
        // }
    }
}
