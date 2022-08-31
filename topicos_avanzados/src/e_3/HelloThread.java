package e_3;

public class HelloThread implements Runnable {
    private String Nombre;

    /**
     * Constructor
     */
    HelloThread(String name) {
        this.Nombre = name;
    }

    /**
     * Metodo run
     */
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " " + Nombre);
        }

        System.out.println("- " + Nombre + " Thread Finished -");
    }

    public static void main(String[] args) {
        /**
         * Instancia de clases
         */
        HelloThread helloThreadPepe = new HelloThread("Pepe");
        Thread t1 = new Thread(helloThreadPepe);
        HelloThread helloThreadJuan = new HelloThread("Juan");
        Thread t2 = new Thread(helloThreadJuan);

        /**
         * Ejecución
         */
        t1.start();
        t2.start();

        /**
         * Fin del main
         */
        System.out.println( "Termina thread main");
    }
}
