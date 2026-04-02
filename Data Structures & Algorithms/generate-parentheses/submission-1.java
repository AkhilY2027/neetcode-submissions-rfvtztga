class Solution {
    private void dfs(int leftPar, int rightPar, List<String> sol, StringBuilder curString) {
        if (rightPar < leftPar) return;
        if (rightPar == 0 && leftPar == 0) sol.add(curString.toString());

        // Either add a left parenthesis or a right parenthesis
        if (leftPar > 0) {
            curString.append("(");
            dfs(leftPar - 1, rightPar, sol, curString);
            curString.deleteCharAt(curString.length() - 1);
        }
        if (rightPar > 0) {
            curString.append(")");
            dfs(leftPar, rightPar - 1, sol, curString);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<>();
        StringBuilder curString = new StringBuilder();
        dfs(n, n, sol, curString);
        return sol;
    }
}
