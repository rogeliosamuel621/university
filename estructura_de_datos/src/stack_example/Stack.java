package stack_example;

public class Stack {
    Node top;
    int size = 0;
    int capacity;

    public void Stack() {
        this.top = null;
        this.size = 0;
    }

    public void Stack(int value) {
        Node node = new Node();
        node.Node(value);
        this.top = node;
        this.upgradeSize();
    }

    public void insert(int value) throws Exception {
        if (this.size == 0) {
            this.insertAtFirstPosition(value);
            return;
        }

        if (this.isFull()) throw new Exception("La pila esta llena");

        Node nodeToInsert = new Node();
        nodeToInsert.Node(value);
        nodeToInsert.prev = this.top;
        this.top = nodeToInsert;
        this.upgradeSize();
    }

    public int remove() throws Exception {
        if (this.isEmpty()) throw new Exception("La pila esta vacia");

        if (this.size == 1) {
            Node nodeToRemove = this.top;
            this.top = null;
            this.downgradeSize();
            return nodeToRemove.data;
        }

        Node nodeToRemove = this.top;
        Node prevNode = this.top.prev;
        this.top = prevNode;
        this.downgradeSize();
        return nodeToRemove.data;
    }

    public void show() throws Exception {
        if (this.isEmpty()) throw new Exception("La pila esta vacia");

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

    public void gi() throws Exception {
        if (this.isEmpty()) throw new Exception("La pila esta vacia");

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

    private void insertAtFirstPosition(int value) {
        Node node = new Node();
        node.Node(value);
        this.top = node;
        this.upgradeSize();
    }
}
