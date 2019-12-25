package circularqueue;

class MyCircularQueue {
    private int[] mQueue;
    private int head;
    private int tail;
    private int total;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        total = k;
        mQueue = new int[k];
        head = -1;
        tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }

        if(isEmpty()) {
            head = 0;
            tail = 0;
        } else {
            tail = (tail + 1) % total;
        }
        mQueue[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }

        mQueue[head] = -1;
        if(head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % total;
        }
        return true;
    }

    /** Get the head item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return mQueue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return mQueue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % total == head;
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
