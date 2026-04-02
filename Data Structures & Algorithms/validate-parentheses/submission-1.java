class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                chars.push(c);
            else {
                // Make sure they match
                if (chars.size() == 0) return false;
                char match = chars.pop();
                if (match == '(' && c != ')') return false;
                if (match == '{' && c != '}') return false;
                if (match == '[' && c != ']') return false;
            }
        }
        return chars.size() == 0;
    }
}
