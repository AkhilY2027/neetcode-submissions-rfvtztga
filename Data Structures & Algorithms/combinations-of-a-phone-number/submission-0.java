class Solution {
    public void backTrack(String digits, int i, List<String> sol, StringBuilder cur) {
        if (i == digits.length()) {
            sol.add(cur.toString());
            return;
        }

        // Do functions based on what digit we end up on
        int curDigit = digits.charAt(i) - '0';
        switch(curDigit) {
            case 2:
                cur.append("a");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("b");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("c");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 3:
                cur.append("d");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("e");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("f");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 4:
                cur.append("g");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("h");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("i");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 5:
                cur.append("j");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("k");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("l");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 6:
                cur.append("m");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("n");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("o");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 7:
                cur.append("p");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("q");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("r");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("s");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 8:
                cur.append("t");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("u");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("v");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            case 9:
                cur.append("w");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("x");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("y");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                cur.append("z");
                backTrack(digits, i + 1, sol, cur);
                cur.delete(cur.length() - 1, cur.length());
                break;
            default:
                return;
        }
    }
    public List<String> letterCombinations(String digits) {
        // Backtrack to all possible combinations
        List<String> sol = new ArrayList<>();
        if (digits.equals("")) return sol;
        backTrack(digits, 0, sol, new StringBuilder());
        return sol;
    }
}
