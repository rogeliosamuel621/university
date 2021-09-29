package priority_queue;

public class PriorityQueue {
    Node[] data;
    int size = 0;
    private int limit = 10;

    public PriorityQueue() {
        this.data = null;
    }

    public void push(int priority, String value) {
        Node newNode = new Node(priority, value);
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
