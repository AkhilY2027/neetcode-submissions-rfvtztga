class LRUCache {

    class LinkedListNode {
        LinkedListNode prev;
        LinkedListNode next;
        int key;
        int val;

        public LinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    // Obviously, want a hashmap to store key, value pair
    // How to handle the "least recently used"?
        // Would prefer if it was O(1)
        // Maybe an arraylist of numbers with a hashmap of its own

    // Easiest Way: Use a LinkedHashMap

    // Without: Instead of using an arraylist to store numbers, use a doubly-linked linkedlist – And pair it with a hashmap
        // In linkedlist, find the node by its key in O(1) time
            // Node can just contain value so we don't need to double up on hashmaps
        // Whenever a key is called on get, we move it from wherever it is in linkedlist to front
        // Whenever we are overcapacity, get rid of "last" node
        // Start with a two node linkedlist (and remember both first and last) for convenience

    int cap;
    HashMap<Integer, LinkedListNode> map;
    LinkedListNode front;
    LinkedListNode back;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.front = new LinkedListNode(0, 0);
        this.back = new LinkedListNode(0, 0);
        this.front.next = this.back;
        this.back.prev = this.front;
    }

    void remove(LinkedListNode curNode) {
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
    }

    void insertIntoBeginning(LinkedListNode curNode) {
        curNode.next = front.next;
        front.next.prev = curNode;
        front.next = curNode;
        curNode.prev = front;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        // Move from original position to front
        LinkedListNode curNode = map.get(key);
        remove(curNode);
        insertIntoBeginning(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        // If already in this, will just be replacing anyway
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        // Add the new node in
        LinkedListNode node = new LinkedListNode(key, value);
        map.put(key, node);
        insertIntoBeginning(node);

        if (map.size() > cap) {
            LinkedListNode last = back.prev;
            remove(last);
            map.remove(last.key);
        }
    }
}
