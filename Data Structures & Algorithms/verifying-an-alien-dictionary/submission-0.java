class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Need to compare the first differing character between adjacent words
            // Already given the order, so just need to see if that character is true

        // 1. Establish the order in ints via an array
        int[] orderArr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orderArr[c - 'a'] = i;
        }

        // 2. Compare differing characters between adjacent words
            // However, keep in mind that words before cannot be longer than words after without a difference
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];

            // Keep going until we find the differing character
            int j = 0;
            while (j < word1.length()) {
                if (j == word2.length()) return false; // Word1 is greater than word2 without a point of difference
                if (word1.charAt(j) != word2.charAt(j)) {
                    // Found the difference
                    if (orderArr[word1.charAt(j) - 'a'] > orderArr[word2.charAt(j) - 'a'])
                        return false;
                    break;
                }
                j++;
            }
        }
        return true;
    }
}