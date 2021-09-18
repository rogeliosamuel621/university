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
        if (this.size == 0) this.insertAtFirstPosition(value);

        if (this.isFull()) throw new Exception("La pila esta llena");

        Node nodeToInsert = new Node();
        nodeToInsert.Node(value);
        nodeToInsert.prev = this.top;
        this.top = nodeToInsert;
        this.upgradeSize();
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

    private void insertAtFirstPosition(int value) {
        Node node = new Node();
        node.Node(value);
        this.top = node;
        this.upgradeSize();
    }
}
