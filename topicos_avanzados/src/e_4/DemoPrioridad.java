package e_4;

public class DemoPrioridad {
    public static void main(String[] args) {
        PrioridadHilos ph1 = new PrioridadHilos("Prioridad Alta");
        PrioridadHilos ph2 = new PrioridadHilos("Prioridad Baja");
        PrioridadHilos ph3 = new PrioridadHilos("Prioridad Nomal #1");
        PrioridadHilos ph4 = new PrioridadHilos("Prioridad Nomarl #2");
        PrioridadHilos ph5 = new PrioridadHilos("Prioridad Nomarl #3");

        ph1.setPriority(Thread.NORM_PRIORITY + 2);
        ph2.setPriority(Thread.NORM_PRIORITY - 2);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();

        try {
            ph1.join();
            ph2.join();
            ph3.join();
            ph4.join();
            ph5.join();
        } catch (Exception e) {
            System.out.println("Hilo principal interrumpido");
        }

        System.out.println();
        System.out.println("Hilo de alta prioridad contó hasta " + ph1.contar);
        System.out.println("Hilo de baja prioridad contó hasta " + ph2.contar);
        System.out.println("Hilo de normal #1 contró hasta  " + ph3.contar);
        System.out.println("Hilo de normal #2 contró hasta  " + ph4.contar);
        System.out.println("Hilo de normal #3 contró hasta  " + ph5.contar);
    }

}
