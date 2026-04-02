class LinkedListNode {
    public int key;
    public int val;
    public LinkedListNode prev;
    public LinkedListNode next;

    public LinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LinkedList {
    // Use a linkedlist to keep track of least recently used
        // If we use something, then add it to the tail – head is least recently used
    LinkedListNode head, tail;

    public LinkedList() {
        // Dummy nodes for convienience
        head = new LinkedListNode(0, 0);
        tail = new LinkedListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void insert(LinkedListNode toAdd) {
        // Insert at tail (prev)
        tail.prev.next = toAdd;
        toAdd.prev = tail.prev;
        toAdd.next = tail;
        tail.prev = toAdd;
    }

    public void remove(LinkedListNode toRemove) {
        // Remove from list
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }
}

class LRUCache {
    
    HashMap<Integer, LinkedListNode> map;
    LinkedList l;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        l = new LinkedList();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // Update most recent here in LinkedList
                // So remove the current key node and readd it to end of list
            l.remove(map.get(key));
            l.insert(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
            l.remove(map.get(key));
        map.put(key, new LinkedListNode(key, value));
        l.insert(map.get(key));
        // Check for capacity
        if (map.keySet().size() > cap) {
            // Evict head pointer from list and map
            LinkedListNode toDelete = l.head.next;
            l.remove(toDelete);
            map.remove(toDelete.key);
        }
    }
}
