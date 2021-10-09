package priority_queue;

public class MainPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);

        priorityQueue.push(5, "no prioridad");
        priorityQueue.push(1, "prioridad");

        System.out.println();
        priorityQueue.show();
    }
}
