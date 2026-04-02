class TimeMap {

    // With HashMap, get() is O(n)
    // However, with TreeMap, items will be sorted -> Can use binary search for O(logn)
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if (!map.containsKey(key)) {
        //     map.put(key, new HashMap<>());
        // }
        // map.get(key).put(timestamp, value);

        // Also, can replicate by saying:
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        // Basically, get the most recent value that is below timestamp
        TreeMap<Integer, String> curTimeStamps = map.get(key);
        Map.Entry<Integer, String> entry = curTimeStamps.floorEntry(timestamp); // Method to binary search the tree for the lowest entry here
            // Map.Entry is used when looping through Map Entries (Key Value pairs)
        return entry == null ? "" : entry.getValue();

        // int lowest = 0;
        // for (int time : .keySet())
        //     if (time > lowest && time <= timestamp)
        //         lowest = time;
        // return map.get(key).getOrDefault(lowest, "");
    }
}
