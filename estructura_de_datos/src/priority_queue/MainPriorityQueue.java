package priority_queue;

public class MainPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);

        priorityQueue.push(5, "Alex");

        priorityQueue.push(1, "Maia");

        priorityQueue.push(2, "Lie");

        priorityQueue.push(2, "Samuel");

        System.out.println();
        priorityQueue.show();
    }
}
