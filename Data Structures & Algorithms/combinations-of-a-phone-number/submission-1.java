class Solution {
    private void dfs(HashMap<Integer, HashSet<Character>> digToChar, char[] digitsArr, int i, List<String> sol, StringBuilder curString) {
        if (i >= digitsArr.length) {
            sol.add(curString.toString().toLowerCase());
            return;
        }

        // System.out.println(digitsArr[i] - '0');

        for (char c : digToChar.get(digitsArr[i] - '0')) {
            // Add the char then go further
            curString.append(c);
            dfs(digToChar, digitsArr, i + 1, sol, curString);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        // Isn't this just dfs?
        HashMap<Integer, HashSet<Character>> digToChar = new HashMap<>();
        for (int i = 2; i < 10; i++)
            digToChar.put(i, new HashSet<>());
        
        // Create the mappings
        digToChar.get(2).add('A');
        digToChar.get(2).add('B');
        digToChar.get(2).add('C');
        digToChar.get(3).add('D');
        digToChar.get(3).add('E');
        digToChar.get(3).add('F');
        digToChar.get(4).add('G');
        digToChar.get(4).add('H');
        digToChar.get(4).add('I');
        digToChar.get(5).add('J');
        digToChar.get(5).add('K');
        digToChar.get(5).add('L');
        digToChar.get(6).add('M');
        digToChar.get(6).add('N');
        digToChar.get(6).add('O');
        digToChar.get(7).add('P');
        digToChar.get(7).add('Q');
        digToChar.get(7).add('R');
        digToChar.get(7).add('S');
        digToChar.get(8).add('T');
        digToChar.get(8).add('U');
        digToChar.get(8).add('V');
        digToChar.get(9).add('W');
        digToChar.get(9).add('X');
        digToChar.get(9).add('Y');
        digToChar.get(9).add('Z');

        // DFS
        List<String> sol = new ArrayList<>();
        dfs(digToChar, digits.toCharArray(), 0, sol, new StringBuilder());
        return sol;
    }
}
