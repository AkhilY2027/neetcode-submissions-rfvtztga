class LRUCache {

    // Obviously, want a hashmap to store key, value pair
    // How to handle the "least recently used"?
        // Would prefer if it was O(1)
        // Maybe an arraylist of numbers with a hashmap of its own

    // Easiest Way: Use a LinkedHashMap
    LinkedHashMap<Integer, Integer> lruCache;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        lruCache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRUCache.this.cap;
            }
        };
    }
    
    public int get(int key) {
        return lruCache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        lruCache.put(key, value);
    }
}
