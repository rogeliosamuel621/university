package queue_example;

public class Queue {
    Node first;
    Node last;
    int capacity;
    int length;

    public Queue(int capacity) {
        this.capacity = capacity;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (this.isFully()) {
            System.out.println("La cola esta llena");
            return;
        }

        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
            this.upgradeLength();
            return;
        }

        this.last.prev = node;
        this.last = node;
        this.upgradeLength();
    }

    public Node remove() {
        if (this.isEmpty()) {
            System.out.println("La cola esta vacia");
            return null;
        }

        if (this.length == 1) {
            Node currentNode = this.first;
            this.first = null;
            this.last = null;
            this.downgradeLength();
            return currentNode;
        }

        Node currentNode = this.first;
        this.first = this.first.prev;
        this.downgradeLength();
        return currentNode;
    }

    public void show() {
        Node currentNode = this.first;

        for(int i=0; i<this.length; i++) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.prev;
        }
    }

    public void show(boolean param) {
        Queue auxQueue = new Queue(this.length);
        int initialLength = this.length;

        for(int i=0; i<initialLength; i++) {
            Node currentNode = this.remove();
            System.out.println(currentNode.getValue());
            auxQueue.insert(currentNode.getValue());
        }

        for(int i=0; i<initialLength; i++) {
            Node currentNode = auxQueue.remove();
            this.insert(currentNode.getValue());
        }
    }

    private boolean isEmpty() {
        return this.length == 0;
    }

    private boolean isFully() {
        return this.length == this.capacity;
    }
    private void upgradeLength() {
        this.length++;
    }

    private void downgradeLength() {
        this.length--;
    }
}
