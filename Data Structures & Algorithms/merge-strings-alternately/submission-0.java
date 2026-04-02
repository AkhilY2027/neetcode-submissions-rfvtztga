class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sol = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length()) {
            sol.append(word1.charAt(i));
            i++;
            if (j < word2.length()) {
                sol.append(word2.charAt(j));
                j++;
            }
            else
                break;
        }

        // Add remaining parts of string
        if (i < word1.length())
            sol.append(word1.substring(i));
        else
            sol.append(word2.substring(j));
        return sol.toString();
    }
}