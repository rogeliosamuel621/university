package queue_example;

public class NodeStack {
    NodeStack prev;
    int data;

    public void NodeStack() {
        this.prev = null;
        this.data = 0;
    }

    public void NodeStack(int data) {
        this.prev = prev;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public NodeStack getPrev() {
        return prev;
    }
}
