class TimeMap {

    // HashMap to a TreeMap so string timestamps will be automatically sorted
    // For get, use a binary search to find the right one – O(nlogn) in total
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        // Binary search
            // Can do the normal keySet then convert to array then binary search, but function is already built in here
        Map.Entry<Integer, String> cur = map.get(key).floorEntry(timestamp);
        return cur == null ? "" : cur.getValue();
    }
}
