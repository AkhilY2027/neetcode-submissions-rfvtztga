class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for (String s : strs) {
            st.append(s.length());
            st.append('#');
            st.append(s);
        }
        return st.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> sol = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int sLen = Integer.parseInt(str.substring(i, j));
            i = j + 1; // Beyond #
            j = i + sLen;
            sol.add(str.substring(i, j));
            i = j;
        }
        return sol;
    }
}
