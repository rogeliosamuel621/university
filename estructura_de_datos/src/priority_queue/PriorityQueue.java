package priority_queue;

import javax.swing.plaf.IconUIResource;

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
        this.limit = limit;
        this.size = INITIAL_SIZE;
    }

    public void push(int priority, String value) {
        if (this.isFull()) {
            System.out.println("Priority queue is full");
            return;
        }

        if (isEmpty()) {
            this.insertAtFirstPosition(priority, value);
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

        this.orderBrothers(parentPosition);
    }

    public void pop() {
        if (this.isEmpty()) {
            System.out.println("Is empty");
            return;
        }
        if (this.size == 2) {
            System.out.println("primero");
            this.data[this.size - 1] = null;
            this.downgradeSize();
            return;
        }

        int currentPosition = this.INITIAL_SIZE;
        int lastPosition = this.size - 1;

        PriorityNode lastNode = this.data[lastPosition];

        this.data[currentPosition] = lastNode;
        this.data[lastPosition] = null;

        int leftChildPosition = 2 * currentPosition;
        int rightChildPosition = 2 * currentPosition + 1;

        PriorityNode leftChild = this.data[leftChildPosition];
        PriorityNode rightChild = this.data[rightChildPosition];

        System.out.println("current node " + lastNode.getValue());
        System.out.println("current position " + currentPosition);
        System.out.println();

        while (rightChild != null || leftChild != null) {
            leftChildPosition = 2 * currentPosition;
            rightChildPosition = 2 * currentPosition + 1;

            leftChild = this.data[leftChildPosition];
            rightChild = this.data[rightChildPosition];

            System.out.println("current position " + currentPosition);
            System.out.println();

            boolean hasTwoChildren = leftChild != null && rightChild != null;

            if (!hasTwoChildren) break;

            if (leftChild == null) {
                if (!(rightChild.getPriority() < lastNode.getPriority())) {
                    System.out.println("derecha");
                    this.data[rightChildPosition] = lastNode;
                    this.data[currentPosition] = rightChild;
                    currentPosition = rightChildPosition;
                    continue;
                }
            }

            if (rightChild == null) {
                if (!(leftChild.getPriority() < lastNode.getPriority())) {
                    System.out.println("izquierda");
                    this.data[leftChildPosition] = lastNode;
                    this.data[currentPosition] = leftChild;
                    currentPosition = leftChildPosition;
                    continue;
                }
            }


            boolean lastNodeHasMorePriority =
                    lastNode.getPriority() < leftChild.getPriority() &&
                    lastNode.getPriority() < rightChild.getPriority();

            if (lastNodeHasMorePriority) {
                break;
            }

            if (rightChild.getPriority() < leftChild.getPriority()) {
                System.out.println("derecha mayor prioridad");
                this.data[rightChildPosition] = lastNode;
                this.data[currentPosition] = rightChild;
                currentPosition = rightChildPosition;

                continue;
            }

            System.out.println("izquierda default");
            this.data[leftChildPosition] = lastNode;
            this.data[currentPosition] = leftChild;
            currentPosition = leftChildPosition;
        }

        this.downgradeSize();

    }

    public void show() {
        for(int i=this.INITIAL_SIZE; i<this.size; i++) {
            System.out.println(data[i].getValue());
        }
    }

    private void orderBrothers(int parentPosition) {
        int leftChildPosition = 2 * parentPosition;
        int rightChildPosition = 2 * parentPosition + 1;

        PriorityNode leftChild = this.data[leftChildPosition];
        PriorityNode rightChild = this.data[rightChildPosition];


        if(leftChild == null || rightChild == null) return;

        if (rightChild.getPriority() < leftChild.getPriority()) {
            this.data[leftChildPosition] = rightChild;
            this.data[rightChildPosition] = leftChild;
        }
    }

    private void insertAtFirstPosition(int priority, String value) {
        PriorityNode newNode = new PriorityNode(priority, value);

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
