class Node {
    int key, val;
    Node next;

    public Node(int key, int val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public Node() {
        this(-1, -1, null);
    }
}

class MyHashMap {

    // Easiest way: Array of Linkedlists – can thus handle collisions
    Node[] arr;

    public MyHashMap() {
        arr = new Node[1000];
        for (int i = 0; i < 1000; i++)
            arr[i] = new Node();
    }

    private int hash(int key) {
        return key % arr.length;
    }
    
    public void put(int key, int value) {
        // Hash so we optimize storage
        Node cur = arr[hash(key)];

        // Upon a collision, need to add to the end of the line
        while (cur.next != null) {
            if (cur.next.key == key) { // Case where we update a value
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new Node(key, value, null);
    }
    
    public int get(int key) {
        // Look through linkedlist to find our element
        Node cur = arr[hash(key)];
        while (cur != null) {
            if (cur.key == key)
                return cur.val;
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node cur = arr[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */