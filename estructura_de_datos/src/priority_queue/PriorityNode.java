package priority_queue;

public class PriorityNode {
    private int priority;
    private String value;

    public PriorityNode() {
        this.priority = 0;
        this.value = "";
    }

    public PriorityNode(int priority, String value) {
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
