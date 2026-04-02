class MyHashSet {

    // Brute Force: Create an array of a million numbers
        // This is heavy space usage and cannot scale well
    // Possible Optimization 1: Make each space a linkedlist, thus can compress the array itself
        // However, possibility that one space will have too many elements depending on hash function
        // Time: O(n/k), Space: O(k + m)
    // Possible Optimzation 2: BST for every node
        // Even faster than linkedlist since trees are compressed even more
        // Time: O(log(n/k)), Space: O(k + m)
    // Possible Optimization 3: Bit Manipulation
        // Basically, any integer can store 32 "values" of 0/1, so there is an inbuilt linkedlist there
        // Use a mask based on the remainder of the key/32 and shift a 1 based on that number
            // Then, add an remove like so
        // Extremely easy to implement

    int[] set;

    public MyHashSet() {
        // set = new int[1000001];
        set = new int[1000000 / 32 + 1];
    }

    private int mask(int key) {
        return 1 << (key % 32);
    }
    
    public void add(int key) {
        // set[key] = 1;
        set[key / 32] |= mask(key);
    }
    
    public void remove(int key) {
        // set[key] = 0;
        if (contains(key))
            set[key / 32] ^= mask(key);
    }
    
    public boolean contains(int key) {
        // return set[key] == 1;
        return (set[key / 32] & mask(key)) != 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */