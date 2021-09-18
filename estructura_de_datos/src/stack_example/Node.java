package stack_example;

public class Node {
    Node prev;
    int data;

    public void Node() {
        this.prev = null;
        this.data = 0;
    }

    public void Node(int data) {
        this.prev = prev;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }
}
