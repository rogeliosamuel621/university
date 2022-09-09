package e_5;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjecutorHilosCajera
{
    private static final int numCajeras = 3;

    public static void main(String[] args)
    {
        ArrayList<Cliente>clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente("Cliente 1", new int[] {2, 2, 1, 5, 2}));
        clientes.add(new Cliente("Cliente 2", new int[] {1, 1, 5, 1, 1}));
        clientes.add(new Cliente("Cliente 3", new int[] {5, 3, 1, 5, 2}));
        clientes.add(new Cliente("Cliente 4", new int[] {2, 4, 3, 2, 5}));
        clientes.add(new Cliente("Cliente 5", new int[] {1, 3, 2, 2, 3}));
        clientes.add(new Cliente("Cliente 6", new int[] {4, 2, 1, 3, 1}));
        clientes.add(new Cliente("Cliente 7", new int[] {3, 3, 2, 4, 7}));
        clientes.add(new Cliente("Cliente 8", new int[] {6, 1, 3, 1, 3}));

        long init = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);

        for (Cliente obtCliente: clientes)
        {
            Runnable cajera = new CajeraRunnable(obtCliente, init);
            executor.execute(cajera);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de procesamiento: " + (fin-init) / 1000 + " Segundos");

    }

}

