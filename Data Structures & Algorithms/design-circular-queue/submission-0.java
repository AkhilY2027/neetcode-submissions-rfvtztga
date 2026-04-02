class MyCircularQueue {

    // Extremely easy to make via an array – just like in OS
    int[] queue;
    int size;
    int frontPointer;
    int backPointer;

    public MyCircularQueue(int k) {
        queue = new int[k];
        size = 0;
        frontPointer = 0; // Where we remove elements
        backPointer = -1; // Where we insert elements
    }
    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        
        backPointer = (backPointer + 1) % queue.length;
        size++;
        queue[backPointer] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())
            return false;
        
        frontPointer = (frontPointer + 1) % queue.length;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[frontPointer];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[backPointer];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */