package project_1;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCarWasherThreads {
    private static final int numOfCarWashers = 3;

    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<Client>();

        clients.add(new Client("Cliente 1", new int[] {2, 2, 1, 5, 2}));
        clients.add(new Client("Cliente 2", new int[] {1, 1, 5, 1, 1}));
        clients.add(new Client("Cliente 3", new int[] {5, 3, 1, 5, 2}));
        clients.add(new Client("Cliente 4", new int[] {2, 4, 3, 2, 5}));
        clients.add(new Client("Cliente 5", new int[] {1, 3, 2, 2, 3}));
        clients.add(new Client("Cliente 6", new int[] {4, 2, 1, 3, 1}));
        clients.add(new Client("Cliente 7", new int[] {3, 3, 2, 4, 7}));
        clients.add(new Client("Cliente 8", new int[] {6, 1, 3, 1, 3}));

        long init = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numOfCarWashers);

        for (Client obtClient: clients)
        {
            Runnable carWasherRunnable = new CarWasherRunnable(obtClient, init);
            executor.execute(carWasherRunnable);
        }

        executor.shutdown();

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de lavado: " + (fin-init) / 1000 + " Segundos");
    }
}
