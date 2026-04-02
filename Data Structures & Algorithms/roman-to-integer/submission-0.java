class Solution {
    public int romanToInt(String s) {
        // Create map for easy comparisons
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Actual solution
        int sol = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(c)) {
                // We have to add the subtracted version
                sol += map.get(s.charAt(i + 1)) - map.get(c);
                i++;
            }
            else sol += map.get(c);
        }
        return sol;
    }
}