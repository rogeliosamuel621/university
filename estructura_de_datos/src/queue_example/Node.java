package queue_example;

public class Node {
    Node prev;
    int value;

    public Node() {
        this.prev = null;
        this.value = 0;
    }

    public Node(int value) {
        this.prev = null;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
