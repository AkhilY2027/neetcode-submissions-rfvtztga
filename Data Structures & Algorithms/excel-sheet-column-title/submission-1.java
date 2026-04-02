class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sol = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Because we start at 1
            int cur = columnNumber % 26;
            sol.insert(0, (char) (cur + 'A'));
            columnNumber /= 26;
        }
        return sol.toString();
    }
}