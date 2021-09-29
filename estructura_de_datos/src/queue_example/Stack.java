package queue_example;

public class Stack {
    NodeStack top;
    int size = 0;
    int capacity;

    public void Stack() {
        this.top = null;
        this.size = 0;
    }

    public void Stack(int value) {
        NodeStack node = new NodeStack();
        node.NodeStack(value);
        this.top = node;
        this.upgradeSize();
    }

    public void insert(int value) {
        if (this.size == 0) {
            this.insertAtFirstPosition(value);
            return;
        }

        if (this.isFull()) System.out.println("La pila esta llena");

        NodeStack nodeToInsert = new NodeStack();
        nodeToInsert.NodeStack(value);
        nodeToInsert.prev = this.top;
        this.top = nodeToInsert;
        this.upgradeSize();
    }

    public int remove()  {
        if (this.isEmpty()) System.out.println("La pila esta vacia");

        if (this.size == 1) {
            NodeStack nodeToRemove = this.top;
            this.top = null;
            this.downgradeSize();
            return nodeToRemove.data;
        }

        NodeStack nodeToRemove = this.top;
        NodeStack prevNode = this.top.prev;
        this.top = prevNode;
        this.downgradeSize();
        return nodeToRemove.data;
    }

    public void show() {
        if (this.isEmpty()) System.out.println("La pila esta vacia");

        Stack auxStack = new Stack();
        int _size = this.size;

        for(int i=0; i<_size; i++) {
            int value = this.remove();
            System.out.println("Nodo: " + value);
            auxStack.insert(value);
        }

        for (int i=0; i<_size; i++) {
            int value = auxStack.remove();
            this.insert(value);
        }
    }

    public void inverse()  {
        if (this.isEmpty()) System.out.println("La pila esta vacia");

        Stack auxStack = new Stack();
        int _size = this.size;

        for(int i=0; i<_size; i++) {
            int value = this.remove();
            auxStack.insert(value);
        }

        auxStack.show();
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void upgradeSize() {
        this.size++;
    }

    private void downgradeSize() {
        this.size--;
    }

    private int getTotalSize(int size) {
        int differenceBetweenSizes = this.size - size;

        if (differenceBetweenSizes < 0) differenceBetweenSizes*= -1;

        int totalSize = this.size + size + differenceBetweenSizes;

        return totalSize;
    }

    private void insertAtFirstPosition(int value) {
        NodeStack node = new NodeStack();
        node.NodeStack(value);
        this.top = node;
        this.upgradeSize();
    }
}

