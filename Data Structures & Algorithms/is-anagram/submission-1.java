class Solution {
    public boolean isAnagram(String s, String t) {
        // if(s.length() != t.length()) return false;
        // char[] ar1 = s.toCharArray();
        // char[] ar2 = t.toCharArray();
        // Arrays.sort(ar1);
        // Arrays.sort(ar2);
        // for(int i = 0; i < ar1.length; i++) {
        //     if(ar1[i] != ar2[i]) return false;
        // }
        // return true;

        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }
}
