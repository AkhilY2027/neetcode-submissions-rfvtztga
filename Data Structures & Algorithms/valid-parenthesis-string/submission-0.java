class Solution {
    private boolean Find(String s, int i, int l) {
        if (i == s.length()) {
            if (l == 0) return true;
            else return false;
        }
        if (l < 0) return false;

        char c = s.charAt(i);
        if (c == '(') return Find(s, i + 1, l + 1);
        else if (c == ')') return Find(s, i + 1, l - 1);
        else return Find(s, i + 1, l) || Find(s, i + 1, l - 1) || Find(s, i + 1, l + 1); // Either left, right, or nothing
    }
    public boolean checkValidString(String s) {
        return Find(s, 0, 0);
    }
}
