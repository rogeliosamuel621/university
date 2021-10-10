package project_1;

import priority_queue.PriorityQueue;

public class ProjectMain {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(20);

        priorityQueue.push(1, "2");
        priorityQueue.push(2, "2");
        priorityQueue.push(2, "5");
        priorityQueue.push(3, "7");
        priorityQueue.push(3, "4");
        priorityQueue.push(3, "7");
        priorityQueue.push(3, "11");
        priorityQueue.push(4, "8");
        priorityQueue.push(4, "10");
        priorityQueue.push(4, "6");

        System.out.println();
        System.out.println("psuh");
        priorityQueue.show();

        priorityQueue.pop();

        System.out.println();
        System.out.println("pop");
        priorityQueue.show();

    }
}
