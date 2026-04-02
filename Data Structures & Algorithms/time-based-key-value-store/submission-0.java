class TimeMap {

    HashMap<String, HashMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        else {
            // Basically, get the most recent value that is below timestamp
            int lowest = 0;
            for (int time : map.get(key).keySet())
                if (time > lowest && time <= timestamp)
                    lowest = time;
            return map.get(key).getOrDefault(lowest, "");
        }
    }
}
