package priority_queue;

/**
 * 2*n left child
 * 2*n+1 right child
 * round (n/2) someone's parent
 * n is equal to array position
 */

public class PriorityQueue {
    PriorityNode[] data;
    int size;
    private int limit;

    private final int DEFAULT_LIMIT = 12;
    private final int INITIAL_SIZE = 1;


    public PriorityQueue(int limit) {
        this.data = new PriorityNode[limit];
        this.limit = limit | this.DEFAULT_LIMIT;
        this.size = INITIAL_SIZE;
    }

    /**
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
    */

    public void push(int priority, String value) {
        if (this.isFull()) {
            System.out.println("Priority queue is full");
            return;
        }

        if (isEmpty()) {
            this.insertAtFirstPosition(value);
            return;
        }

        int currentPosition = this.size;
        PriorityNode newNode = new PriorityNode(priority, value);

        data[currentPosition] = newNode;
        this.upgradeSize();

        int parentPosition = this.getParentPosition(currentPosition);
        PriorityNode parentNode = this.data[parentPosition];

        while (currentPosition != this.INITIAL_SIZE && parentNode.getPriority() > newNode.getPriority()) {
            // exchange
            this.data[currentPosition] = parentNode;
            this.data[parentPosition] = newNode;

            // update positions
            currentPosition = parentPosition;
            parentPosition = this.getParentPosition(currentPosition);

            // get new parentNode
            parentNode = this.data[parentPosition];
        }
    }

    public void show() {
        for(int i=this.INITIAL_SIZE; i<this.size; i++) {
            System.out.println(data[i].getValue());
        }
    }

    private void insertAtFirstPosition(String value) {
        PriorityNode newNode = new PriorityNode(1, value);

        this.data[this.size] = newNode;
        this.upgradeSize();
    }

    private int getParentPosition(int position) {
        return (int)(position / 2);
    }

    private boolean isEmpty(){
        return this.size == this.INITIAL_SIZE;
    }

    private boolean isFull() {
        return this.size == this.limit;
    }

    private void upgradeSize() {
        this.size++;
    }

    private void downgradeSize() {
        this.size--;
    }
}
