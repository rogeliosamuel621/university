package priority_queue;

public class MainPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);

        priorityQueue.push(5, "Alan");
        priorityQueue.push(1, "Maia");
        priorityQueue.push(1, "Lie");
        priorityQueue.push(5, "Alan");
        priorityQueue.push(1, "Maia");
        priorityQueue.push(1, "Lie");
        priorityQueue.push(5, "Alan");
        priorityQueue.push(1, "Maia");
        priorityQueue.push(1, "Lie");
        priorityQueue.push(5, "Alan");
        priorityQueue.push(1, "Maia");
        priorityQueue.push(1, "Lie");

        System.out.println();
        priorityQueue.show();
    }
}
