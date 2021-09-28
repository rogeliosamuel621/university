package priority_queue;

public class Node {
    private int priority;
    private String value;

    public Node() {
        this.priority = 0;
        this.value = "";
    }

    public Node(int priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public String getValue() {
        return value;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
