package priority_queue;

/**
 * 2*n left child
 * 2*n+1 right child
 * round (n/2) someone's parent
 * n is equal to array position
 */

public class PriorityQueue {
    PriorityNode[] data;
    int size = 0;
    private int limit = 10;

    public PriorityQueue() {
        this.data = null;
    }

    public void push(int priority, String value) {
        PriorityNode newNode = new PriorityNode(priority, value);
        this.size++;

        if (this.isEmpty()) {
            data[size] = newNode;
            return;
        }

        int position = this.size;
        data[position] = newNode;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
