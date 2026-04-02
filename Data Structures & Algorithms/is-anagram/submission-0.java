class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ar1 = s.toCharArray();
        char[] ar2 = t.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        for(int i = 0; i < ar1.length; i++) {
            if(ar1[i] != ar2[i]) return false;
        }
        return true;
    }
}
