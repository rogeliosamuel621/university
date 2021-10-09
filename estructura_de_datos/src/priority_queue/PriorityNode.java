package priority_queue;

public class PriorityNode {
    private int priority;
    private String value;

    public PriorityNode() {
        this.priority = 1;
        this.value = "";
    }

    public PriorityNode(int priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getValue() {
        return this.value;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
