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

    public void remove() {
        if (this.isEmpty()) {
            System.out.println("La cola esta vacia");
            return;
        }

        if (this.length == 1) {
            this.first = null;
            this.last = null;
            this.downgradeLength();
            return;
        }

        this.first = this.first.prev;
        this.downgradeLength();
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
