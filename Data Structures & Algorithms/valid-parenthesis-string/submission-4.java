class Solution {
    private boolean dfs(int i, String s, int leftPar) {
        if (i >= s.length())
            return leftPar == 0;
        if (leftPar < 0)
            return false;
        
        char c = s.charAt(i);
        if (c == '(')
            return dfs(i + 1, s, leftPar + 1);
        else if (c == ')')
            return dfs(i + 1, s, leftPar - 1);
        else
            return dfs(i + 1, s, leftPar + 1) | dfs(i + 1, s, leftPar - 1) | dfs(i + 1, s, leftPar);
    }
    public boolean checkValidString(String s) {
        // Can do a dfs for the * character
        return dfs(0, s, 0);
    }
}
