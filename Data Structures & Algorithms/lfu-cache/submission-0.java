class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int value) {
        val = value;
    }

    public ListNode(int value, ListNode prev, ListNode next) {
        val = value;
        this.prev = prev;
        this.next = next;
    }
}

class DoublyLinkedList {
    private ListNode head, tail;
    private Map<Integer, ListNode> map;

    DoublyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0, head, null);
        head.next = tail;
        map = new HashMap<>();
    }

    public int length() {
        return map.size();
    }

    public void pushRight(int val) {
        ListNode newNode = new ListNode(val, tail.prev, tail);
        map.put(val, newNode);
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void popIfFound(int val) {
        if (map.containsKey(val)) {
            ListNode node = map.get(val);
            ListNode prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            map.remove(val);
        }
    }

    public int popLeft() {
        int leftMostVal = head.next.val;
        popIfFound(leftMostVal);
        return leftMostVal;
    }

    public void update(int val) {
        popIfFound(val);
        pushRight(val);
    }
}

class LFUCache {

    // Builds on top of the LRU (Least Recently Used) Cache problem
        // Thus, store the "least frequently" used in a doubly linkedlist – Whenever we put or get, we move the element behind or forward in the list
    // However, since we are going based on frequency rather than time, we need multiple linkedlists
        // Each linkedlist will pair to a "frequency" (Ex. Nodes that were used once, nodes that were used twice, etc.)
        // This way, we keep a track of frequencies and also recently used nodes in case of a tie

    HashMap<Integer, Integer> valMap; // Key -> Value
    HashMap<Integer, Integer> countMap; // Key -> Frequency
    HashMap<Integer, DoublyLinkedList> freqMap; // Frequency -> List
    int capacity;
    int lfuCount; // What is the lfu we must look for whenever we are at capacity – Constantly update

    public LFUCache(int capacity) {
        this.capacity = capacity;
        lfuCount = 0;
        valMap = new HashMap<>();
        countMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void counter(int key) { // Called whenever we put or get on a key – Thus, must update the frequency
        // 1. Remove key from original frequency linkedlist
        int count = countMap.getOrDefault(key, 0);
        freqMap.putIfAbsent(count, new DoublyLinkedList());
        freqMap.get(count).popIfFound(key);

        // 2. Put key into the new frequency linkedlist and update the frequency
        int newCount = count + 1;
        countMap.put(key, newCount);
        freqMap.putIfAbsent(newCount, new DoublyLinkedList());
        freqMap.get(newCount).pushRight(key);

        if (count == lfuCount && freqMap.get(count).length() == 0) // No more of that frequency left, so update lfu count to next frequency – guarenteed to have one since we just updated
            lfuCount++;
    }
    
    public int get(int key) {
        if (!valMap.containsKey(key))
            return -1;
        counter(key);
        return valMap.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (!valMap.containsKey(key) && valMap.size() == capacity) { 
            // Case where we have are at capacity
            int toRemove = freqMap.get(lfuCount).popLeft();
            valMap.remove(toRemove);
            countMap.remove(toRemove);
        }

        valMap.put(key, value);
        counter(key);
        lfuCount = Math.min(lfuCount, countMap.get(key));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */