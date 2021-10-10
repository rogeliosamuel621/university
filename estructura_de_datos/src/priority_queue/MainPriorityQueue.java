package priority_queue;

public class MainPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);

        priorityQueue.push(1, "Maia");
        priorityQueue.push(1, "Samuel");
        priorityQueue.push(1, "Alan");
        priorityQueue.push(5, "Raul");
        priorityQueue.push(2, "Lie");
        priorityQueue.push(2, "Alberto");
        priorityQueue.push(1, "Bnet");


        System.out.println();
        priorityQueue.show();
    }
}
