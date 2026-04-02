class Solution {
    public boolean palCheck(String s, int l, int r) {
        // Basic O(n) check
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public void dfs(String s, int index, List<String> curPartitions, List<List<String>> res) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(curPartitions)); // Add a copy of the list since we will always change it
            return;
        }

        // Again, get all possible indeces
        for (int i = index; i < s.length(); i++) {
            if (palCheck(s, index, i)) {
                curPartitions.add(s.substring(index, i + 1));
                dfs(s, i + 1, curPartitions, res);
                curPartitions.remove(curPartitions.size() - 1); // Must remove since its the same data structure
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, 0, temp, result);
        return result;
    }
}
