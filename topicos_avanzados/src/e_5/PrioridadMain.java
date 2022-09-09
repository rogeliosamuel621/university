package e_5;

public class PrioridadMain
{

    public static void main(String[] args)
    {
        PrioridadHilos ph1 = new PrioridadHilos("Prioridad Alta");
        PrioridadHilos ph2 = new PrioridadHilos("Prioridad Baja");
        PrioridadHilos ph3 = new PrioridadHilos("Prioridad Normal #1");
        PrioridadHilos ph4 = new PrioridadHilos("Prioridad Normal #2");
        PrioridadHilos ph5 = new PrioridadHilos("Prioridad Normal #3");

        ph1.setPriority(Thread.NORM_PRIORITY+2);
        ph2.setPriority(Thread.NORM_PRIORITY-2);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();

        try
        {
            ph1.join();
            ph2.join();
            ph3.join();
            ph4.join();
            ph5.join();

        }catch(InterruptedException e)
        {
            System.out.println("Hilo principal Interrumpido");
        }

        System.out.println("\nHilo de alta prioridad contó hasta: " + ph1.contar);
        System.out.println("Hilo de baja prioridad contó hasta: " + ph2.contar);
        System.out.println("Hilo de prioridad normal #1 contó hasta: " + ph3.contar);
        System.out.println("Hilo de prioridad normal #2 contó hasta: " + ph4.contar);
        System.out.println("Hilo de prioridad normal #3 contó hasta: " + ph5.contar);

    }

}

