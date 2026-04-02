class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Sliding Window on s2
            // We say that we have a permutation when sliding window's characters match the characters within s1
        if (s2.length() < s1.length())
            return false;
        
        // s1 characters
        int[] s1Chars = new int[26];
        for (char c : s1.toCharArray())
            s1Chars[c - 'a']++;
        // System.out.println(Arrays.toString(s1Chars));
        
        // Sliding Window for s2
        int[] s2Chars = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; i++)
            s2Chars[s2.charAt(i) - 'a']++;
        if (Arrays.toString(s2Chars).equals(Arrays.toString(s1Chars)))
            return true;
        // System.out.println(Arrays.toString(s2Chars));
        for (int i = n; i < s2.length(); i++) {
            s2Chars[s2.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i - n) - 'a']--;
            if (Arrays.toString(s2Chars).equals(Arrays.toString(s1Chars)))
                return true;
            // System.out.println(Arrays.toString(s2Chars));
        }
        return false;
    }
}
