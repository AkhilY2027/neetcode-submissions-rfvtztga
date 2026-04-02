class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        // Don't we just increment an index pointer and check? – O(n * m)
        int minStringLen = Integer.MAX_VALUE;
        for (int s = 0; s < strs.length; s++)
            minStringLen = Math.min(minStringLen, strs[s].length());
        int i = 0;
        while (i < minStringLen) {
            // Go through every string – if it does work, then break
            boolean inc = true;
            for (int s = 1; s < strs.length; s++) {
                if (strs[s].charAt(i) != strs[0].charAt(i)) {
                    inc = false;
                    break;
                }
            }
            if (!inc)
                break;
            i++;
        }
        return i == 0 ? "" : strs[0].substring(0, i);
    }
}